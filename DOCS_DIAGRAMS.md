# CinemaDaw — Diagrams

## 1. Class Diagram

```mermaid
classDiagram
    direction TB

    class Cinema {
        +Long id
        +String cinemaName
        +String address
        +String city
        +String postalCode
        +String imageUrl
    }

    class Room {
        +Long id
        +String name
        +int capacity
    }

    class Seat {
        +Long id
        +String seatrow
        +int seatNumber
        +SeatType type
        +int x
        +int y
        +boolean estado
    }

    class SeatType {
        <<enumeration>>
        Standard
        Premium
        Adapted
    }

    class Movie {
        +Long id
        +String title
        +int min
        +String gener
        +String descripcion
        +LocalDate date
        +String posterUrl
    }

    class Screening {
        +Long id
        +LocalDateTime screeningDateTime
        +Double precio
    }

    class SeatBooking {
        +Long id
    }

    class Order {
        +Long id
        +LocalDateTime orderDateTime
        +double totalAmount
        +String clientName
        +String clientEmail
        +OrderStatus status
    }

    class OrderStatus {
        <<enumeration>>
        PENDING
        CONFIRMED
        CANCELLED
    }

    class Ticket {
        +Long id
        +double price
    }

    class User {
        +Long id
        +String username
        +String password
        +Role role
    }

    class Role {
        <<enumeration>>
        ADMIN
        CLIENT
    }

    class LoyaltyCard {
        +Long id
        +String cardNumber
        +int points
        +LocalDate memberSince
        +getDiscountValue() double
    }

    class News {
        +String headline
        +String body
    }

    Cinema      "1"  -->  "*"  Room        : has
    Room        "*"  -->  "1"  Cinema      : belongs to
    Room        "1"  -->  "*"  Seat        : contains
    Seat        "*"  -->  "1"  Room        : belongs to
    Seat              -->       SeatType   : typed as

    Screening   "*"  -->  "1"  Movie       : screens
    Screening   "*"  -->  "1"  Room        : held in
    Screening   "1"  -->  "*"  SeatBooking : tracks bookings
    Screening   "1"  -->  "*"  Ticket      : issues

    SeatBooking "*"  -->  "1"  Seat        : reserves
    SeatBooking "*"  -->  "1"  Screening   : for

    Order       "1"  -->  "*"  Ticket      : contains
    Order             -->       OrderStatus : has status
    Ticket      "*"  -->  "1"  Order       : part of
    Ticket      "*"  -->  "1"  Screening   : for
    Ticket      "*"  -->  "1"  Seat        : occupies

    LoyaltyCard "1"  -->  "1"  User        : belongs to
    User              -->       Role        : has role
```

---

## 2. Use Case Diagram

> Actors and permissions are derived from `SecurityConfig.java`.  
> Specific use cases are inferred from the domain entities.

```mermaid
graph LR
    Guest(["👤 Guest\n(Anonymous)"])
    Client(["👤 Client\n(ROLE_CLIENT)"])
    Admin(["👤 Admin\n(ROLE_ADMIN)"])

    subgraph Public [" Public — permitAll "]
        UC_Home["View Home Page\n(/)"]
        UC_Login["Log In\n(/login)"]
        UC_Register["Register\n(/register)"]
        UC_Logout["Log Out\n(/logout)"]
        UC_Cookies["View Cookie Policy\n(/cookies/**)"]
    end

    subgraph ClientArea [" Client Area — ROLE_CLIENT or ROLE_ADMIN "]
        UC_Movies["Browse Movies\n(/client/movies)"]
        UC_Screenings["View Screenings\n(/client/screenings)"]
        UC_Seats["Select Seats\n(/client/seats)"]
        UC_Cart["Manage Cart\n(/client/cart)"]
        UC_Order["Place Order\n(/client/order)"]
        UC_Loyalty["View Loyalty Card\n(/client/loyalty)"]
        UC_Session["Manage Session\n(/session/**)"]
    end

    subgraph AdminArea [" Admin Area — ROLE_ADMIN only "]
        UC_ManageCinemas["Manage Cinemas\n(/admin/cinemas)"]
        UC_ManageRooms["Manage Rooms\n(/admin/rooms)"]
        UC_ManageSeats["Manage Seats\n(/admin/seats)"]
        UC_ManageMovies["Manage Movies\n(/admin/movies)"]
        UC_ManageScreenings["Manage Screenings\n(/admin/screenings)"]
        UC_ManageOrders["Manage Orders\n(/admin/orders)"]
        UC_H2["Access H2 Console\n(/h2-console/**)"]
    end

    Guest  --> UC_Home
    Guest  --> UC_Login
    Guest  --> UC_Register
    Guest  --> UC_Logout
    Guest  --> UC_Cookies

    Client --> UC_Home
    Client --> UC_Login
    Client --> UC_Logout
    Client --> UC_Movies
    Client --> UC_Screenings
    Client --> UC_Seats
    Client --> UC_Cart
    Client --> UC_Order
    Client --> UC_Loyalty
    Client --> UC_Session

    Admin  --> UC_Home
    Admin  --> UC_ManageCinemas
    Admin  --> UC_ManageRooms
    Admin  --> UC_ManageSeats
    Admin  --> UC_ManageMovies
    Admin  --> UC_ManageScreenings
    Admin  --> UC_ManageOrders
    Admin  --> UC_H2
    Admin  -.->|"can also access\nClient Area"| ClientArea
```
