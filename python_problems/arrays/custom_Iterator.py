import bisect


class Iterator:

    def __init__(self, data):
        self.data = data
        self.current_index = 0


    def has_next(self) -> bool:
        return self.current_index < len(self.data)


    def next(self):
        if not self.has_next():
            raise StopIteration
        current_value = self.data[self.current_index]
        self.current_index += 1
        return current_value


    def get_state(self):
        if not self.has_next():
            raise StopIteration
        return self.data[self.current_index]


    def set_state(self, state):
        if not self.has_next():
            raise StopIteration
        self.data[self.current_index] = state


class MultiIterator:
    def __init__(self, iterators):
        self.iterators = iterators
        self.global_index = 0
        self.iterators_lengths = [len(iterator.data) for iterator in self.iterators]
        self.prefix = [0]
        for length in self.iterators_lengths:
            self.prefix.append(self.prefix[-1] + length)


    def has_next(self) -> bool:
        return self.global_index < self.prefix[-1]


    def next(self):
        if not self.has_next():
            raise StopIteration
        current_iterator = self._get_current_iterator()
        self.global_index += 1
        return current_iterator.next()


    def get_state(self):
        if not self.has_next():
            raise StopIteration
        return self._get_current_iterator().get_state()


    def set_state(self, state):
        if not self.has_next():
            raise StopIteration
        self._get_current_iterator().set_state(state)


    def _get_current_iterator(self):
        idx = bisect.bisect_right(self.prefix, self.global_index) - 1
        return self.iterators[idx]

#Testing
it1 = Iterator([1, 2, 3])
it2 = Iterator([4, 5])
it3 = Iterator([6])

multi = MultiIterator([it1, it2, it3])

while multi.has_next():
    if multi.get_state() % 2 == 0:
        multi.set_state(multi.get_state() * 100)
    print(multi.next())