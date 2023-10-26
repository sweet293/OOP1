class Bike:
    def __init__(obj):
        obj.speed = 0
        obj.isMoving = False
    def stop(obj):
        obj.isMoving = False
    def accelerate(obj, amount):
        obj.speed += amount
        obj.isMoving = obj.speed != 0
    def printSpeed(obj):
        print("Speed:", obj.speed)
    def printIsMoving(obj):
        if obj.isMoving:
            print("The bike is moving")
        else:
            print("The bike is not moving")

print(Bike)