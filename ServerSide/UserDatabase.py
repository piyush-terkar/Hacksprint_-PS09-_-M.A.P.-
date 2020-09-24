import pickle


class UserDatabase:

    def __init__(self, name, passwd, addr):
        self.name = name
        self.passwd = passwd
        self.addr = addr


with open("database", "rb") as file1:
    try:
        database = pickle.load(file1)
    except EOFError:
        database = []


def signup(name, passwd, addr):
    a = UserDatabase(name, passwd, addr)
    with open("database", "ab") as file:
        database.append(a)
        pickle.dump(database, file)
        return 0


def login(name, passwd):
    if len(database) != 0:
        for i in database:
            if i.name == name and i.passwd == passwd:
                result = 0
                return result
            elif i.name == name:
                result = 1
                return result
    else:
        print("User not found, please create a new account")
        result = '-1'
        return result
