public class Main {
    public static void main(String[] args) {

        //Создадим паспорт
        Passport passport_1 = new Passport(1234567890);
        //Заполним его поля
        passport_1.setSecondName("Иванов");
        passport_1.setFirstName("Иван");
        passport_1.setPatronymic("Иванович");
        passport_1.setYearOfBirth(1970);
        System.out.println("----------------------------------------------------------");
        //Создадим паспорт
        Passport passport_2 = new Passport(1234567890);
        //Заполним его поля
        passport_1.setSecondName("Иванов");
        passport_1.setFirstName("Иван");
        passport_1.setPatronymic("Иванович");
        passport_1.setYearOfBirth(1970);
        System.out.println("----------------------------------------------------------");
        //Добавим оба паспорта в список паспортов
        Passport.PassportStorage.addPassport(passport_1);
        Passport.PassportStorage.addPassport(passport_2);
        System.out.println("----------------------------------------------------------");
        //Создадим еще один паспорт
        Passport passport_3 = new Passport(111111);
        //Заполним его поля
        passport_3.setSecondName("AAAA");
        passport_3.setFirstName("BBBB");
        passport_3.setPatronymic("CCCC");
        passport_3.setYearOfBirth(1990);
        System.out.println("----------------------------------------------------------");
        //Добавим паспорт в список паспортов
        Passport.PassportStorage.addPassport(passport_3);
        System.out.println("----------------------------------------------------------");
        //Посмотрим список паспортов
        System.out.println(Passport.PassportStorage.passportStorage);



    }
}