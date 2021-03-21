package es.urjc.cloudapps.insurancecompany.clients.domain;

public class Client {

    private final ClientId id;

    private final String name;

    private final String surname;

    private final ClientAddress address;

    public Client(final ClientId id, final String name, final String surname, final ClientAddress address) {
        ensureIdIsPresent(id);
        ensureNameIsPresent(name);
        ensureSurnameIsPresent(surname);
        ensureAddressIsPresent(address);

        this.id      = id;
        this.name    = name;
        this.surname = surname;
        this.address = address;
    }

    private static void ensureIdIsPresent(final ClientId id) {
        if (id == null) throw new IllegalArgumentException("Client id must not be null");
    }

    private static void ensureNameIsPresent(final String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Client name must not be null or empty");
    }

    private static void ensureSurnameIsPresent(final String sn) {
        if (sn == null || sn.isBlank()) throw new IllegalArgumentException("Client surname must not be null or empty");
    }

    private static void ensureAddressIsPresent(final ClientAddress addr) {
        if (addr == null) throw new IllegalArgumentException("Client address must not be null");
    }

    public ClientId getId() {
        return id;
    }

    public String getIdAsString() {
        if (this.id != null) {
            return this.id.getId();
        } else {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ClientAddress getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
}
