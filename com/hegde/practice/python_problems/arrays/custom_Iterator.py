#TODO: Complete this.
class Iterator:

    def __init__(self, data):
        self.data = data
        self.current_index = 0


    def has_next(self) -> bool:
        return self.current_index + 1 < len(self.data)


    def next(self):
        if not self.has_next():
            raise StopIteration
        current_value = self.data[self.current_index]
        self.current_index += 1
        return current_value


    def get_state(self):
        return self.data[self.current_index]


    def set_state(self, state):
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


    def get_state(self):


    def set_state(self, state):

