package me.whiteship.chapter04.item17.part1;

/**
 * 3. Person 은 불변 클래스이지만 내부적으로 가변 컴포넌트(Address) 를 가지고 있음
 */
public final class Person {

    private final Address address; // 가변 컴포넌트

    public Person(Address address) {
        this.address = address;
    }

    /**
     * 4. 가변 컴포넌트에 접근할 수 없도록 getter 를 제공하지 않거나,
     *    꼭 제공해야한다면 방어적 복사로 제공해야한다.
     */
    public Address getAddress() {
        Address copyOfAddress = new Address();
        copyOfAddress.setStreet(address.getStreet());
        copyOfAddress.setZipCode(address.getZipCode());
        copyOfAddress.setCity(address.getCity());
        return copyOfAddress;
    }

    public static void main(String[] args) {
        Address seattle = new Address();
        seattle.setCity("Seattle");

        Person person = new Person(seattle);

        Address redmond = person.getAddress();
        redmond.setCity("Redmond");

        System.out.println(person.address.getCity()); // 변경되지 않았음
    }
}
