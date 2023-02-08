# Bank-System
Создайте класс Operation, который наследует от класса Thread с параметрами:
 
- String operationName;
- int operationTime; //время операции в секундах
 
Переопределите метод run() в котором мы запускаем наш поток, и выводим на экран:
Например operationTime = 4, operationName = "Add Client to Bank"
 
        Operation "Add Client to Bank": started
        Operation "Add Client to Bank": 1 second
        Operation "Add Client to Bank": 2 second
        Operation "Add Client to Bank": 3 second
        Operation "Add Client to Bank": 4 second
        Operation "Add Client to Bank": finished
 
То есть, ежесекундно мы выводим состояние операции на экран, тем самым показывая сколько времени у нас уходит на одно действие.
В итоге, в главном классе создайте 10 объектов операции и назначьте для них разное время. Запустите их одновременно.
 
