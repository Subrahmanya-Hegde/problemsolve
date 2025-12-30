class Solution:
    def numberOfInversions(self, nums):
        def merge(array, low, mid, high):
            sorted_array = []
            left, right = low, mid + 1
            count = 0

            while left <= mid and right <= high:
                if array[left] <= array[right]:
                    sorted_array.append(array[left])
                    left += 1
                else:
                    sorted_array.append(array[right])
                    count += (mid - left + 1)
                    right += 1

            sorted_array.extend(array[left:mid + 1])
            sorted_array.extend(array[right: high + 1])

            array[low: high + 1] = sorted_array

            return count

        def merge_sort(array, low, high):
            count = 0
            if low >= high:
                return count

            mid = (low + high) // 2

            count += merge_sort(array, low, mid)
            count += merge_sort(array, mid + 1, high)
            count += merge(array, low, mid, high)

            return count

        return merge_sort(nums, 0, len(nums) - 1)