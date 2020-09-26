import socket

client = socket.socket()
ip = "192.168.1.30"
port = 8001
client.connect((ip, port))
while True:
    signal = input("give input:")
    client.send(bytes(signal.encode()))
    print(client.recv(1024))