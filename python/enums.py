from enum import Enum

class Category(Enum):
    Dish = 0
    Ingredient = 1

print(Category.Dish) # Category.Dish
print(Category.Dish.value) # 0
print(Category.Dish.name) # Dish
print(Category['Dish']) # Category.Dish
print(Category.Dish.name == 'Dish') # True
print(Category['OK']) # Key Error: 'OK'