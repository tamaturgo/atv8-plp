class IObserver:  # interface
    def update(self, subject):
        pass


class ISubject:  # interface
    def attach(self, observer):
        pass

    def detach(self, observer):
        pass

    def notify(self):
        pass

    def setValue(self, value):
        pass

class DecimalDigitsObserver(IObserver):
    def update(self, subject):
        print("Digits:", subject.getValue())

class OctalObserver(IObserver):
    def update(self, subject):
        print("Octal String: ", str(oct(subject.getValue())))
    
class HexObserver(IObserver):
    def update(self, subject):
        print("Hex String: ", str(hex(subject.getValue())))

class BinaryObserver(IObserver):
    def update(self, subject):
        print("Binary String: ", str(bin(subject.getValue())))

class Number(ISubject):
    def __init__(self, value):
        self.__observers = []
        self.__value = value

    def attach(self, observer):
        self.__observers.append(observer)

    def detach(self, observer):
        self.__observers.remove(observer)

    def notify(self):
        for observer in self.__observers:
            observer.update(self)

    def setValue(self, value):
        self.__value = value
        self.notify()

    def getValue(self):
        return self.__value

class Main:
    def main(self):
        number = Number(42)
        print("Initial value: ", number.getValue(), "\n")
        octalObserver = OctalObserver()
        hexObserver = HexObserver()
        binaryObserver = BinaryObserver()
        decimalDigitsObserver = DecimalDigitsObserver()
        number.attach(octalObserver)
        number.attach(hexObserver)
        number.attach(binaryObserver)
        number.attach(decimalDigitsObserver)

        # Change the value
        number.setValue(42)
        print("\n ----------- ")

        # Change the value
        number.setValue(43)
        print("\n ----------- ")

        # Change the value + detach
        number.detach(octalObserver)
        number.setValue(44)

if __name__ == "__main__":
    Main().main()
