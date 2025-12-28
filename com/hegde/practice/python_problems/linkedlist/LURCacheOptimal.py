from collections import deque

class LRUCache:
    def __init__(self, n):
        self.capacity = n
        self.queue = deque()
        self.cache = {}


    def get(self, key):
        if key in self.cache:
            self.queue.remove(key)
            self.queue.append(key)
            return self.cache[key]
        else:
            return None

    def set(self, key, val):
        if key in self.cache:
            self.queue.remove(key)
        elif len(self.queue) == self.capacity:
            least_used_cache = self.queue.popleft()
            del self.cache[least_used_cache]
        self.cache[key] = val
        self.queue.append(key)


# debug your code below
cache = LRUCache(2)
cache.set('user1', 'Alex')
print(cache.get('user1'))