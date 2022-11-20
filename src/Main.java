public class Main {
    public static void main(String[] args) {

        //Создадим паспорт
        Passport passport_1 = new Passport(1234567890);
        //Заполним его поля
        passport_1.setSecondName("Иванов");
        passport_1.setFirstName("Иван");
        passport_1.setPatronymic("Иванович");
        passport_1.setYearOfBirth(1970);
        //Создадим паспорт
        Passport passport_2 = new Passport(1234567890);
        //Заполним его поля
        passport_2.setSecondName("Иванов");
        passport_2.setFirstName("Иван");
        passport_2.setPatronymic("Иванович");
        passport_2.setYearOfBirth(1970);
        //Создадим еще один паспорт
        Passport passport_3 = new Passport(1234567890);
        //Заполним его поля
        passport_3.setSecondName("AAAA");
        passport_3.setFirstName("BBBB");
        passport_3.setPatronymic("CCCC");
        passport_3.setYearOfBirth(1990);
        //Создадим еще один паспорт
        Passport passport_4 = new Passport(111);
        //Заполним его поля
        passport_4.setSecondName("A");
        passport_4.setFirstName("B");
        passport_4.setPatronymic("C");
        passport_4.setYearOfBirth(2001);
        //Добавим паспорт в список паспортов
        Passport.PassportStorage.addPassport(passport_1);
        Passport.PassportStorage.addPassport(passport_2);
        Passport.PassportStorage.addPassport(passport_3);
        Passport.PassportStorage.addPassport(passport_4);
        System.out.println("----------------------------------------------------------");
        //Посмотрим список паспортов
        System.out.println("Список паспортов:");
        System.out.println(Passport.PassportStorage.passportStorage);
        System.out.println("----------------------------------------------------------");
        System.out.println(Passport.PassportStorage.findByNumber(1));
    }
}