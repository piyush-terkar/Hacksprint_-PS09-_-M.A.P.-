

class ProductDatabase:
    def __init__(self, catagory, name, stock, cost):
        self.catagory = catagory
        self.name = name
        self.stock = stock
        self.cost = cost


# ------------------------------------------------------------------


fruit_1 = []
vegetable_2 = []
cereals_3 = []
dairy_5 = []
cleaning_4 = []


def sort(catagory, a):
    if catagory == 1:
        fruit_1.append(a)
    elif catagory == 2:
        vegetable_2.append(a)
    elif catagory == 3:
        cereals_3.append(a)
    elif catagory == 5:
        dairy_5.append(a)
    elif catagory == 4:
        cleaning_4.append(a)
    else:
        print('Enter valid catagory number ')


def search_category(catagory, name):
    if catagory == 1:
        return search(name, fruit_1)
    elif catagory == 2:
        return search(name, vegetable_2)
    elif catagory == 3:
        return search(name, cereals_3)
    elif catagory == 4:
        return search(name, cleaning_4)
    elif catagory == 5:
        return search(name, dairy_5)
    else:
        return ProductDatabase("", "", "", "")


def search(name, list):
    for i in list:
        if name == i.name:
            return i
    else:
        return ProductDatabase("", "", "", "")

# ---------------------------------------------------------------------


f1 = ProductDatabase(1, "apple", 10, 5)
sort(f1.catagory, f1)
f2 = ProductDatabase(1, "mango", 20, 10)
sort(f2.catagory, f2)
f3 = ProductDatabase(1, "oranges", 40, 4)
sort(f3.catagory, f3)
f4 = ProductDatabase(1, "watermelon", 50, 40)
sort(f4.catagory, f4)
f5 = ProductDatabase(1, "papaya", 40, 25)
sort(f5.catagory, f5)
f6 = ProductDatabase(1, "pineapple", 45, 35)
sort(f6.catagory, f6)
f7 = ProductDatabase(1, "kiwi", 50, 15)
sort(f7.catagory, f7)
f8 = ProductDatabase(1, "guava", 30, 5)
sort(f8.catagory, f8)
f9 = ProductDatabase(1, "banana", 60, 4)
sort(f9.catagory, f9)
f10 = ProductDatabase(1, "jackfruit", 55, 30)
sort(f10.catagory, f10)
v_1 = ProductDatabase(2, "cucumber", 40, 6)
sort(v_1.catagory, v_1)
v_2 = ProductDatabase(2, "tomato", 60, 3)
sort(v_2.catagory, v_2)
v_3 = ProductDatabase(2, "peas", 30, 15)
sort(v_3.catagory, v_3)
v_4 = ProductDatabase(2, "pumpkin", 20, 15)
sort(v_4.catagory, v_4)
v_5 = ProductDatabase(2, "ginger", 40, 4)
sort(v_5.catagory, v_5)
v_6 = ProductDatabase(2, "onion", 80, 20)
sort(v_6.catagory, v_6)
v_7 = ProductDatabase(2, "capsicum", 50, 5)
sort(v_7.catagory, v_7)
v_8 = ProductDatabase(2, "potato", 45, 10)
sort(v_8.catagory, v_8)
v_9 = ProductDatabase(2, "cabbage", 30, 25)
sort(v_9.catagory, v_9)
v_10 = ProductDatabase(2, "brinjal", 50, 10)
sort(v_10.catagory, v_10)
c_1 = ProductDatabase(3, "wheat", 100, 50)
sort(c_1.catagory, c_1)
c_2 = ProductDatabase(3, "rice", 90, 60)
sort(c_2.catagory, c_2)
c_3 = ProductDatabase(3, "jowar", 70, 40)
sort(c_3.catagory, c_3)
c_4 = ProductDatabase(3, "bajra", 65, 45)
sort(c_4.catagory, c_4)
c_5 = ProductDatabase(3, "ragi", 50, 40)
sort(c_5.catagory, c_5)
c_6 = ProductDatabase(3, "tur dal", 90, 35)
sort(c_6.catagory, c_6)
c_7 = ProductDatabase(3, "moong dal", 90, 30)
sort(c_7.catagory, c_7)
c_8 = ProductDatabase(3, "matki", 40, 25)
sort(c_8.catagory, c_8)
c_9 = ProductDatabase(3, "masoor", 40, 20)
sort(c_9.catagory, c_9)
c_10 = ProductDatabase(3, "poha", 90, 40)
sort(c_10.catagory, c_10)
c1 = ProductDatabase(4, "santoor soap", 50, 20)
sort(c1.catagory, c1)
c2 = ProductDatabase(4, "dove soap", 50, 25)
sort(c2.catagory, c2)
c3 = ProductDatabase(4, "pears soap", 50, 25)
sort(c3.catagory, c3)
c4 = ProductDatabase(4, "dettol soap", 50, 15)
sort(c4.catagory, c4)
c5 = ProductDatabase(4, "cinthol soap", 50, 30)
sort(c5.catagory, c5)
c6 = ProductDatabase(4, "himalaya face wash", 50, 15)
sort(c6.catagory, c6)
c7 = ProductDatabase(4, "lotus face wash", 40, 45)
sort(c7.catagory, c7)
c8 = ProductDatabase(4, "himalaya shampoo", 50, 30)
sort(c8.catagory, c8)
c9 = ProductDatabase(4, "clinic plus shampoo", 40, 35)
sort(c9.catagory, c9)
c10 = ProductDatabase(4, "sunsilk shampoo", 40, 25)
sort(c10.catagory, c10)
c11 = ProductDatabase(4, "nyle shampoo", 50, 40)
sort(c11.catagory, c11)
d1 = ProductDatabase(5, "milk", 50, 54)
sort(d1.catagory, d1)
d2 = ProductDatabase(5, "cheese", 50, 15)
sort(d2.catagory, d2)
d3 = ProductDatabase(5, "bread", 50, 25)
sort(d3.catagory, d3)
d4 = ProductDatabase(5, "butter", 40, 15)
sort(d4.catagory, d4)
d5 = ProductDatabase(5, "paneer", 40, 15)
sort(d5.catagory, d5)
d6 = ProductDatabase(5, "basundi", 30, 20)
sort(d6.catagory, d6)
d7 = ProductDatabase(5, "dahi", 20, 15)
sort(d7.catagory, d7)
