# # Online Python compiler (interpreter) to run Python online.
# # Write Python 3 code in this online editor and run it.
# from abc import ABC, abstractmethod
#
# class Animal(ABC):
#     @abstractmethod
# def feed():
#     pass
#
# class Dog(Animal):
#
#     def __init__(self, legs):
#         self.__private_legs = legs
#
#     def feed(self):
#         print("feeding dog")
#     pass
#
#     def get_legs(self):
#         return self.__private_legs
#
# @staticmethod
# def static_response():
#     return "Have a great day sweat heart"
#
#
#     print("Try programiz.pro")
#     dog = Dog(4);
#     print(dog.feed())
#
#     print(dog.get_legs())
#
#     print(Dog.static_response())
#     print(dog.static_response())
#
#
#     for i in range(1,10):
#         print("range ", i)
#
#     li :list = ["one", "two", "three", "four"]
#     for each in li:
#         print("each ", each)
#
#     li2 = filter(lambda n: len(n) > 3, li)
#     for l2 in li2:
#         print("li2 ", l2)
#
#     touppercase = list(map(str.upper, li))
#     for upp in touppercase:
#         print("upper ", upp)
#
#     numbers = [1, 2, 3, 4, 5, 6]
#
#     multiple = map(lambda n : n * n, numbers)
#     for m in multiple:
#         print("multi ", m)
#
#     my_set = {1, 2}
#     my_set.add(8)
#
#     my_list = [2,3,4,5]
#     my_set.update(my_list)
#     my_set.remove(5)
#     print(my_set)
#
#     def write(str):
#         def consolelog():
#         print(str)
#
#     return consolelog
#
#     log = write("hello world")
#
#     log()
#
#     def my_decorator(func):
#         def wrapper():
#         print("Something is happening before the function is called.")
#     func()
#     print("Something is happening after the function is called.")
#     return wrapper
#
# @my_decorator
# def say_hello():
#     print("Hello!")
#
#     say_hello()
#
#     def repeat(no):
#         def repeat_decorator(func):
#     # This wrapper function is the replacement for 'greet'
#     def wrapper(*args):
#     # The loop runs ONLY when wrapper (i.e., greet) is called
#     for i in range(no):
#         print(f"--- Repeating {i + 1} time ---")
#     # CALL the original function (func) inside the loop
#     func(*args)
#
#     return wrapper # Return the function that contains the loop logic
#
#     return repeat_decorator
#
# @repeat(no=5)
# def greet(name):
#     print(f"hello Hi {name} ")
#
#     greet("sweaty")
# hash_map = dict({"name":"yashas"})
# hash_map["name"] = "Yashas Rai"
# hash_map["RS"] = 200
# for key, value in hash_map.items():
#     print("key ", key, " value ", value)
# for keys in hash_map.keys():
#     print("keys ", keys)
#
# for vals in hash_map.values():
#     print("vals ", vals)
# Online Python compiler (interpreter) to run Python online.
# Write Python 3 code in this online editor and run it.
# from abc import ABC, abstractmethod
#
#
# class User:
#     def __init__(self, age, name):
#         self.age = age
#         self.name = name
#
#     def __init__(self, name):
#         self.name = name;
#
#     def printName(self):
#         print("printing name : ", self.name)
#
#
#
#
#
# user1 = User("Yashas");
# user1.printName();
#
# tuple = ("name", "age", "phone")
# first = tuple[0];
# second = tuple[1];
# third = tuple[2];
#
# print(first, " ", second, " ", third)
#
#
# li: list = ["apple", "ball", "cat"]
#
# li.append("dog")
#
# li.reverse();
# print(li)
#
# def two() -> (int, int):
#     return 1, 2
# a, b = two()
# print(a, b)
#
# class Animal(ABC):
#     def makeSound(self):
#         print("animal making sound")
#
#     @abstractmethod
#     def feed(self):
#         pass
#         # print("feed your animal")
#
# class Dog(Animal):
#     def makeSound(self):
#         print("woof woof")
#
#     def feed(self):
#         print("feeding tommy")
#
#
# dog = Dog()
# dog.feed()
# dog.makeSound()
#
#
# class Service(ABC):
#
#     @abstractmethod
#     def call(self):
#         pass
#
#     @abstractmethod
#     def print(self):
#         pass
#
# class ServiceImpl(Service):
#     def call(self):
#         print("calling the method")
#
#     def print(self):
#         print("printing .......")
#
#
# obj = ServiceImpl()
# obj.call()
# obj.print()
#
# num = 1;
# num = num+1 if num == 1 else 1
# print(num)
#
# li = ["one", "two", "three"]
#
# l2 = filter(lambda n: n not in ["one", "two"], li)
# print(l2)
#
# for each in l2:
#     print("each ", each)
#
#
# numbers = [1, 2, 3, 4]
#
# total = sum(map(lambda n : n  , numbers))
# print("total ",total)
#
# def outerfunc(text):
#     def innerfunc():
#         print(text)
#     return innerfunc
#
# f = outerfunc("print some closure")
#
# f()
#
#
# def decorator(func):
#     def funcall():
#         func()
#     return funcall
#
#
# @decorator
# def fu():
#     print("performing heavy ops")
# fu()
# # de = decorator(fu)
# # de()
#
# def generators():
#     yield "a"
#     yield "b"
#     yield "c"
#
# val = generators()
# print("yield ",next(val))
#
# print("yield ", next(val))
#
#
# print("yield ", next(val))
#
# # print("yield ", next(val))
#
#
# class People:
#     def __init__(self, name):
#         self.__private_name = name
#
#     def name(self):
#         return self.__private_name
#
#
# people = People("Yashas")
#
# print("people name is ", people.name())