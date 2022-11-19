import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Passport {

    private final int number;
    private String firstName;
    private String secondName;
    private String patronymic = "отсутствует";
    private int yearOfBirth;

    public Passport(int number) {
        this.number = number;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Паспортные данные гражданина - ФИО: " + secondName + " " + firstName + " " + patronymic + "\n" +
                "номер паспорта: " + number + ", год рождения гражданина: " + yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport)) return false;
        Passport passport = (Passport) o;
        return getNumber() == passport.getNumber() && getYearOfBirth() == passport.getYearOfBirth() && getFirstName().equals(passport.getFirstName()) && getSecondName().equals(passport.getSecondName()) && getPatronymic().equals(passport.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getFirstName(), getSecondName(), getPatronymic(), getYearOfBirth());
    }

    public static class PassportStorage {

        static Map<Integer, Passport> passportStorage = new HashMap<>();

        static public void addPassport(Passport passport) {
            int passportNumber = passport.getNumber();
            System.out.println("Добавляем в список паспорт с номером " + passportNumber);
            //Сравним номер входящего паспорта с имеющимися номерами в списке
            if (passportStorage.isEmpty() || !passportStorage.containsKey(passportNumber)) {
                passportStorage.put(passport.getNumber(), passport);
                System.out.println("Паспорт добавлен в список");
                System.out.println("Список после добавления паспорта " + passportStorage);
            } else {
                System.out.println("Паспорт с таким номером уже есть в списке");
                System.out.println("Обновим значения полей");
                //Если паспорт с таким номером уже есть в списке, то надо обновить поля этого паспорта
                //получим паспорт из списка по номеру паспорта
                Passport bufferPassport = passportStorage.get(passportNumber);
                //Обновим поля
                //Почему входящий объект Passport имеет нулевые поля, кроме номера паспорта?
                System.out.println(passport.getFirstName());//почему null????????????
                System.out.println("---------------------------------------------------------");
                bufferPassport.setFirstName(passport.getFirstName());
                bufferPassport.setSecondName(passport.getSecondName());
                bufferPassport.setPatronymic(passport.getPatronymic());
                bufferPassport.setYearOfBirth(passport.getYearOfBirth());
                System.out.println("Паспортные данные после редактирования:");
                System.out.println(bufferPassport);
                //Положим обновленный паспорт опять в список
                passportStorage.put(passportNumber, bufferPassport);
            }
        }
    }
}
