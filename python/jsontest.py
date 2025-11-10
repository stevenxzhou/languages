from json import JSONEncoder, dumps

class Animal:
    def __init__(self, name):
        self.name = name

class AnimalEncoder(JSONEncoder):
    def default(self, o):
        if isinstance(o, Animal):
            return o.name
        return super().default(o)

animals_dict = {'a': Animal("123"), 'b': Animal('123')}
print(dumps(animals_dict, cls=AnimalEncoder))