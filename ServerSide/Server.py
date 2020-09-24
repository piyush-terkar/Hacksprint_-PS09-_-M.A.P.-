import socket
import UserDatabase
import ProductDatabase

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

ip = "192.168.1.30"
port = 8000
server.bind((ip, port))
server.listen(10)
client, addr = server.accept()

while True:
    print("Connection Established")
    signal = client.recv(1024)
    signal = signal.decode(encoding='utf-8', errors='ignore')
    signal = signal.strip()
    signal = str(signal)
    signal = signal.split(',')
    print(signal)
    if signal[0] == 'l':
        result = UserDatabase.login(signal[1], signal[2])
        client.send(str(result).encode(encoding='utf-8', errors='ignore'))
    elif signal[0] == 'si':
        result = UserDatabase.signup(signal[1], signal[2], signal[3])
        client.send(str(result).encode(encoding='utf-8', errors='ignore'))
    elif signal[0] == 'se':
        i = ProductDatabase.search_category(int(signal[1]), signal[2])
        client.send((str(i.catagory) + str(i.name) + " " + str(i.stock) + " " + str(i.cost)).encode(encoding='utf-8', errors='ignore'))
        print("sent")
    else:
        result = "-1"
        client.send(str(result).encode(encoding='utf-8', errors='ignore'))
    server.close()
