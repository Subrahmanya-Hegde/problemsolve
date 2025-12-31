import time
from dataclasses import dataclass, field
from typing import Tuple, Dict

"""
TokenBucket algorithm for rate limiting.
https://en.wikipedia.org/wiki/Token_bucket
"""
@dataclass
class CustomRateLimiter:
    rate_per_second: float
    capacity: float
    store: Dict[str, Tuple[float, float]]
    cost: float = 1

    def __init__(self, rate_per_second: float, capacity: float) -> None:
        self.rate_per_second = rate_per_second
        self.capacity = capacity
        self.store = {}

    def allow(self, key: str) -> bool:
        now = time.time()
        last_ts, tokens = self.store.get(key, (now, self.capacity))
        elapsed = now - last_ts
        tokens_remaining = min(self.capacity, tokens + elapsed * self.rate_per_second)

        # print("Now: " + str(now) + "; last_ts: " + str(last_ts) + "; elapsed" + str(elapsed) + "; tokens_remaining: " + str(tokens_remaining))

        if tokens_remaining < self.cost:
            self.store[key] = (now, tokens_remaining)
            return False

        tokens_remaining -= self.cost
        self.store[key] = (now, tokens_remaining)
        return True


#Testing
ratelimiter = CustomRateLimiter(5, 10)
for i in range(1000):
    fooHit = ratelimiter.allow('foo')

    if i % 10 == 0:
        barHit = ratelimiter.allow('bar')

    message = "Foo Hit" if fooHit else "Foo Miss"
    print(message)
    message = "Bar Hit" if barHit else "Bar Miss"

    print (message)
    if i % 100 == 0:
        time.sleep(1)