from dataclasses import field, dataclass
from typing import Dict, List

DELETED = object()

@dataclass
class KeyValueStorage:

    store: Dict[str, str] = field(default_factory=dict)
    stack: List[Dict[str, str]] = field(default_factory=list)

    def begin(self):
        self.stack.append({})


    def set(self, key: str, value: str):
        if self.stack:
            self.stack[-1][key] = value
        else:
            self.store[key] = value


    def unset(self, key: str):
        if self.stack:
            self.stack[-1][key] = DELETED
        else:
            del self.store[key]


    def get(self, key: str) -> str:
        for layer in reversed(self.stack):
            if key in layer:
                if layer[key] is DELETED:
                    raise KeyError(key)
                return layer[key]
        return self.store[key]


    def commit(self):
        if not self.stack:
            raise RuntimeError("No transaction found")
        else:
            if len(self.stack) > 1:
                last_transaction = self.stack.pop()
                for key, value in last_transaction.items():
                    self.stack[-1][key] = value
            else:
                last_transaction = self.stack.pop()
                for key, value in last_transaction.items():
                    if value is not DELETED:
                        self.store[key] = value
                    else:
                        del self.store[key]


    def abort(self):
        if not self.stack:
            raise RuntimeError("No transaction found")
        del self.stack[-1]

#Testing
kv = KeyValueStorage()
kv.set("key1", "random value 1")
kv.set("key2", "random value 2")
print(kv.get("key1"))
print(kv.get("key2"))
kv.begin()
kv.set("key1", "1st transaction key 1")
kv.set("key2", "1st transaction key 2")
print("Inside 1st transaction")
print(kv.get("key1"))
print(kv.get("key2"))
kv.begin()
kv.set("key1", "2nd transaction key 1")
kv.set("key2", "2nd transaction key 2")
print("Inside 2nd transaction")
print(kv.get("key1"))
print(kv.get("key2"))
kv.abort()
print("Aborted 2nd transaction")
print(kv.get("key1"))
print(kv.get("key2"))
kv.unset("key1")
kv.commit()
print("Committing values")
print(kv.get("key1")) #Key error.
print(kv.get("key2"))
