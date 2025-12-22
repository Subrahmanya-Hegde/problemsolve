class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:
    def __init__(self, n):
        self.capacity = n
        self.cache = {}

        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head


    def _remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev


    def _push_node_at_the_top(self, node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node


    def get(self, key):
        if key in self.cache:
            node = self.cache[key]

            self._remove(node)
            self._push_node_at_the_top(node)

            return node.value


    def set(self, key, val):
        if key in self.cache:
            node = self.cache[key]
            self._remove(node)

        node = Node(key, val)
        self.cache[key] = node
        self._push_node_at_the_top(node)

        if len(self.cache) > self.capacity:
            lru_node = self.tail.prev
            self._remove(lru_node)
            del self.cache[lru_node.key]


# debug your code below
cache = LRUCache(2)
cache.set('user1', 'Alex')
print(cache.get('user1'))