class MathUtils:

    def calculate_sum(self, number):
        total_sum = 0
        for i in range(1, number):
            if i % 3 == 0 or i % 5 == 0:
                total_sum += i
        return total_sum

number = int(input("Enter a number: "))
sum_calculator = MathUtils()
result = sum_calculator.calculate_sum(number)
print(result)