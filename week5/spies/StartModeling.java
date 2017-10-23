package week5.spies;

public class StartModeling {
    public static void main(String[] args) {

        Congress congressOfCorrupt = new Congress();

        Agency antiCorruptionAgency = new Agency();

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Гриценко Анатолій Степанович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Канівець Олег Леонідович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Саакашвілі Міхеїл Ніколозович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Садовий Андрій Іванович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Сироїд Оксана Іванівна", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Ярош Дмитро Анатолійович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Білецький Андрій Євгенійович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Вінтонів Роман Іванович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Гацько Василь Миколайович", antiCorruptionAgency), congressOfCorrupt);

        antiCorruptionAgency.sendForAPurpose(
                new Spy("Заліщук Світлана Петрівна", antiCorruptionAgency), congressOfCorrupt);

        congressOfCorrupt.conductCongress();

        congressOfCorrupt.leave();
    }

}
