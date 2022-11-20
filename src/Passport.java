import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Passport {

    private final int number;
    @NotNull private String firstName = getFirstName();
    @NotNull private String secondName = getSecondName();
    private String patronymic = "отсутствует";
    private int yearOfBirth;

    public Passport(int number) {
        this.number = number;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(@NotNull String secondName) {
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

    public @NotNull String getFirstName() {
        if (firstName != null) {
            return firstName;
        }
        return "имя не указано";
    }

    public @NotNull String getSecondName() {
        if (secondName != null) {
            return secondName;
        }
        return "фамилия не указана";
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

        static public Passport findByNumber(int number) {
            if (passportStorage.containsKey(number)) {
                System.out.println("Найден паспорт с таким номером:");
                System.out.println(passportStorage.get(number));
            } else {
                System.out.println("Паспорт с таким номером не найден");
                return null;
            }
            return passportStorage.get(number);
        }

        static public void addPassport(Passport passport) {
            int passportNumber = passport.getNumber();
            System.out.println("Добавляем в список паспорт с номером " + passportNumber);
            //Сравним номер входящего паспорта с имеющимися номерами в списке
            if (passportStorage.isEmpty() || !passportStorage.containsKey(passportNumber)) {
                passportStorage.put(passport.getNumber(), passport);
                System.out.println("Паспорт добавлен в список");
                System.out.println("Список после добавления паспорта " + passportStorage);
                System.out.println("---------------------------------------------------------");
            } else {
                System.out.println("Паспорт с таким номером уже есть в списке");

                //Если паспорт с таким номером уже есть в списке, то надо обновить поля этого паспорта
                //получим паспорт из списка по номеру паспорта
                Passport bufferPassport = passportStorage.get(passportNumber);
                System.out.println("Вот этот паспорт:");
                System.out.println(bufferPassport);
                System.out.println("Обновим значения его полей");

                //Обновим поля - возьмем имя, и год рождения из входящего объект Passport
                //и обновим поля буфферного паспорта
                bufferPassport.setFirstName(passport.getFirstName());
                bufferPassport.setSecondName(passport.getSecondName());
                bufferPassport.setPatronymic(passport.getPatronymic());
                bufferPassport.setYearOfBirth(passport.getYearOfBirth());
                //Положим обновленный паспорт опять в список
                passportStorage.put(passportNumber, bufferPassport);
                System.out.println("Обновленный паспорт добавлен в список");
                System.out.println("---------------------------------------------------------");
            }
        }
    }
}
