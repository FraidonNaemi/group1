-- Create database
create database if not exists store;

-- Enter into store database
use store;

-- Create customer table
create table customers(
    customerID integer primary key auto_increment,
    customerName varchar(50) not null,
    customerEmail varchar(50) not null unique,
    customerPassword varchar(20) not null,
    customerDOB date not null,
    customerPhoneNumber varchar(12) not null,
    customerAddress varchar(100) not null
);

-- Create admin table
create table admins(
    adminID integer primary key auto_increment,
    adminName varchar(50) not null,
    adminEmail varchar(50) not null unique,
    adminPassword varchar(20) not null,
    adminDOB date not null,
    adminPhoneNumber varchar(12) not null,
    adminAddress varchar(100) not null
);

-- Create orders table
create table orders(
    orderID integer primary key auto_increment,
    orderDate date not null,
    customerID integer not null,
    foreign key(customerID) references customers(customerID)
    on delete cascade
    on update cascade
);

-- Create products table
create table products(
    productID integer primary key auto_increment,
    productImage varchar(100) not null,
    productName varchar(50) not null unique,
    productPrice double not null,
    productCategory varchar(25) not null,
    productDescription varchar(1000),
    productStock integer not null
);

-- Create orderProduct table
create table orderProducts(
    orderID integer not null,
    productID integer not null,
    quantity integer not null,
    foreign key(orderID) references orders(orderID)
    on delete cascade
    on update cascade,
    foreign key(productID) references products(productID)
    on delete cascade
    on update cascade
);

-- Adding record to the customer table
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Jack Paul', 'jack.paul@store.com', 'Hellojack123', '1987-09-28', '+61470987654', '12 George St, Sydney NSW 2000');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Alex Bergen', 'alex.bergen@store.com', 'Helloalex123', '1977-10-02', '0470011456', '30 Samphire St, Sydney NSW 2141');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Dylan Duncan', 'dylan.duncan@store.com', 'Hellodelan123', '1963-10-27', '0470643446', '11 Delhi St, Sydney NSW 2120');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Gabriel Russell', 'gabriel.russell@store.com', 'Hellogabriel123', '1993-02-18', '0422434462', '22 Sweet St, Sydney NSW 2161');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Aiden Marshall', 'aiden.marshall@store.com', 'Helloaiden123', '1995-11-02', '0424872678', '4 John St, Sydney NSW 2000');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Edward McLean', 'edward.mcLean@store.com', 'Helloedward123', '1992-01-22', '0472162435', '2 Railway St, Sydney NSW 2023');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Logan Robertson', 'logan.robertson@store.com', 'Hellologan123', '1991-01-02', '0478987678', '23 Clark Dr, Sydney NSW 2153');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Sam Peterson', 'sam.peterson@store.com', 'Hellosam123', '1990-05-23', '0474587324', '24 Norbrik Dr, Sydney NSW 2153');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Rio Glenn', 'rio.glenn@store.com', 'Hellorio123', '1990-05-23', '0476383224', '5 Olympic Dr, Sydney NSW 2140');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Adam Tylor', 'adam.tylor@store.com', 'Helloadam123', '2003-11-02', '0476345190', '1 Joseph St, Sydney NSW 2030');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Marcus Jones', 'marcus.jones@store.com', 'Hellomarcus123', '2001-02-10', '0475645021', '3 Park Rd, Sydney NSW 2110');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Thomas Burt', 'thomas.burt@store.com', 'Hellothomas123', '1978-03-15', '0475237812', '13 Martin Cr, Sydney NSW 2050');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Michael Wilson', 'michael.wilson@store.com', 'Hellomichael123', '1988-10-01', '0474289629', '23 Hunter St, Sydney NSW 2123');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Chris Bowen', 'chris.bowen@store.com', 'Hellochris123', '1994-07-15', '0471234680', '12 Jacob St, Sydney NSW 2120');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Jordan Morris', 'jordan.morris@store.com', 'Hellojordan123', '1999-12-09', '0470298239', '17 Darcy Rd, Sydney NSW 2153');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Max Fisher', 'max.fisher@store.com', 'Hellomax123', '1981-10-23', '0471487842', '19 Anthony Dr, Sydney NSW 2020');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('George Graham', 'george.grahan@store.com', 'Hellogeorge123', '1997-05-09', '0429019478', '2 George St, Sydney NSW 2000');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('James Lee', 'james.lee@store.com', 'Hellojames123', '2002-04-28', '0409387658', '12 Jacob Ave, Sydney NSW 2025');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Oscar Ryan', 'oscar.ryan@store.com', 'Helloryan123', '1995-05-25', '0470987654', '27 Allison Rd, Sydney NSW 2131');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Ryan Rogers', 'ryan.rogers@store.com', 'Hellorogers123', '1993-12-13', '0476541234', '32 Martin Rd, Sydney NSW 2152');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Harry Baker', 'harry.baker@store.com', 'Helloharry123', '1990-10-12', '0472689017', '9 Walker St, Sydney NSW 2142');
insert into customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress) values('Customer', 'customer.customer@store.com', 'Hellocustomer123', '1992-10-02', '0472312523', '4 Jacob St, Sydney NSW 2004');

-- Adding record to the admin table
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Niko Payal', 'niko.payal@store.com', 'Helloniko123', '1996-03-18', '0470268364', '9 Deborah Ave, Sydney NSW 2161');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Isaac Dawson', 'isaac.dawson@store.com', 'Helloisaac123', '2003-11-09', '+61470263421', '21 Joseph St, Sydney NSW 2167');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Benjamin Elliott', 'benjamin.elliott@store.com', 'Hellobenjamin123', '1992-02-23', '0478765432', '5 Arnold St, Sydney NSW 2025');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Henry Otto', 'henry.otto@store.com', 'Hellohenry123', '1991-01-14', '0429098172', '25 Walgrove Rd, Sydney NSW 2261');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Declan Allen', 'declan.allen@store.com', 'Hellodeclan123', '2004-11-23', '0476547658', '14 Delan St, Sydney NSW 2001');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Robert Swan', 'robert.swan@store.com', 'Hellorobert123', '2001-02-16', '0478765409', '10 Kai Rd, Sydney NSW 2221');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('John Hamilton', 'john.hamilton@store.com', 'Hellojohn123', '2002-10-29', '04701238735', '10 Fleming Rd, Sydney NSW 2021');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Liam Johnson', 'liam.johnson@store.com', 'Helloliam123', '2000-02-15', '0428376456', '8 Henry Dr, Sydney NSW 2000');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Jerrod Braun', 'jerrod.braun@store.com', 'Hellojerrod123', '1993-05-23', '0428709811', '16 Rohan St, Sydney NSW 2119');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Morris Zieme', 'morris.zieme@store.com', 'Hellomorris123', '1992-02-13', '0478276198', '29 Kernal Ave, Sydney NSW 2150');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Brant Goodwin', 'brant.goodwin@store.com', 'Hellobrant123', '1997-07-19', '0428901927', '14 Voughan Rd, Sydney NSW 2141');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Johnathon Schuppe', 'johnathon.schuppe@store.com', 'Hellojohnathon123', '2000-01-12', '0471829187', '15 John St, Sydney NSW 2140');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Martin Raynor', 'martin.raynor@store.com', 'Hellomartin123', '1990-10-02', '0472323345', '2 Mumbai St, Sydney NSW 2153');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Kenny Greenholt', 'kenny.greenholt@store.com', 'Hellokenny123', '1991-03-27', '0428909187', '16 Railway St, Sydney NSW 2160');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Herman Jacobson', 'herman.jacobson@store.com', 'Helloherman123', '1999-01-30', '0428971652', '27 Oliver St, Sydney NSW 2000');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Robert Herzog', 'robert.herzog@store.com', 'Hellorobert123', '2001-10-07', '0420981827', '15 Harvard St, Sydney NSW 2001');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Eldon Schinner', 'eldon.schinner@store.com', 'Helloeldon123', '2002-09-15', '0472851726', '2 Willliam St, Sydney NSW 2142');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('William Lee', 'william.lee@store.com', 'Hellowilliam123', '2000-04-18', '0428909871', '19 Joseph St, Sydney NSW 2006');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('David Chang', 'david.chang@store.com', 'Hellodavid123', '1999-02-26', '04273678991', '20 Harris St, Sydney NSW 2154');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Adolf Gibson', 'adolf.gibson@store.com', 'Helloadolf123', '1996-01-24', '0421239874', '8 Park Rd, Sydney NSW 2142');
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Alfred Borer', 'alfred.borer@store.com', 'Helloalfred123', '1989-11-02', '0472653487', '3 James Rd, Sydney NSW 2020');  
insert into admins(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress) values('Admin Admin', 'admin.admin@store.com', 'Helloadmin123', '1992-06-09', '0472349561', '2 Jacob St, Sydney NSW 2006');

-- Adding record to the products table
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The Confident Mind', 18.39, 'Book' , 'The Confident Mind book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The God Equation', 27.33, 'Book' , 'The God Equation book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Atomic Habits', 21.95, 'Book' , 'Atomic Habits book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The Power of Letting Go', 33.43, 'Book' , 'The Power of Letting Go book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The Universe Speaks in Numbers', 31.75, 'Book' , 'The Universe Speaks in Numbers book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The Mysteries of the Universe', 25, 'Book' , 'The Mysteries of the Universe book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Space', 27.33, 'Book' , 'Space book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The New Martians', 29.22, 'Book' , 'The New Martians book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Artifact Space', 33.43, 'Book' , 'Artifact Space book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Project 369', 44.44, 'Book' , 'Project 369 book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Cosmic Careers', 34.96, 'Book' , 'Cosmic Careers book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'This Book Will Blow Your Mind', 30.38, 'Book' , 'This Book Will Blow Your Mind book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'How to Die in Space', 34.09, 'Book' , 'How to Die in Space book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The Quantum Series', 43.87, 'Book' , 'The Quantum Series book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Starry Night', 79, 'Book' , 'Starry Night');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The Last Astronaut', 30.38, 'Book' , 'The Last Astronaut book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Out There', 41.31, 'Book' , 'Out There book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', '2084', 25.40, 'Book' , '2084 book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Think Again', 25.99, 'Book' , 'Think Again');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'The Universe Always Has a Plan', 22.42, 'Book' , 'The Universe Always Has a Plan book');
-- insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('URL', 'Space 2069', 25.83, 'Book' , 'Space 2069');

-- Adding record to the products table
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('kit-kat.jpg', 'Nestle Kitkat', 1, 'Chocolates' , 'Nestle Kitkat 4 Finger Milk Chocolate Bar', 5);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('mars-chocolate.jpg', 'Mars Chocolate', 1, 'Chocolates' , 'Mars Chocolate Bar With Nougat & Caramel', 10);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('snickers-chocolate.jpg', 'Snickers Chocolate', 1, 'Chocolates' , 'Nestle Milkybar Milk & Cookies 180g Block', 7);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('nestle-milkybar-milk.jpg', 'Nestle Milkybar Milk', 5.50, 'Chocolates' , 'The Power of Letting Go book', 4);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('lindt-lindor-milk.jpg', 'Lindt Lindor Milk', 12, 'Chocolates' , 'Lindt Lindor Milk Chocolate Balls', 12);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('men-shoes.jpg', 'Men Shoes', 15, 'Sport' , 'Circuit men zen Sport shoes - black', 18);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('sport-bottle.jpg', 'Sport Bottle', 11, 'Sport' , 'Stay hydrate sports bottle - assorted', 25);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('sport-bag.jpg', 'Sports Bag', 18, 'Sport' , 'Circuit sports bag - black', 17);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('boxing-gloves.PNG', 'Boxing Combo Set', 120, 'Sport' , 'VIP boxing combo set - Red', 2);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('punch-bag.jpg', 'Punch Bag', 650, 'Sport' , 'Everlast punching bag - black', 9);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('sony-tv.jpg', 'Sony X75K 65" Bravia', 1699, 'Tech' , 'Sony X75K 65" Bravia LED 4K UHD HDR', 6);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('apple-watch.jpg', 'Apple Watch Series 8', 650, 'Tech' , 'Apple Watch Series 8 GPS 45mm Midnight Aluminium Case', 4);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('apple-ipad.jpg', 'Apple iPad', 749, 'Tech' , 'Apple iPad Wi-Fi 64GB - Blue', 7);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('logitech-keyboard.jpg', 'Logitech Keyboard', 650, 'Tech' , 'Logitech Multi-Device Keyboard - gray', 11);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('homedics-massager.jpg', 'Homedics Therapist Massager', 150, 'Health & Beauty' , 'Homedics Therapist Plus Percussion Massager', 18);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('colgate-toothbrush.jpg', 'Colgate Slim Toothbrush', 6, 'Health & Beauty' , 'Colgate Slim Soft Advanced Charcoal Manual Toothbrush', 6);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('colgate-toothpaste.jpg', 'Colgate Max Fresh Toothpaste', 8, 'Health & Beauty' , 'Colgate Max Fresh Toothpaste With Mini Breath Strips 200g', 16);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('pantene-shampoo.jpg', 'Pantene Pro-V Shampoo', 20, 'Health & Beauty' , 'Pantene Pro-V Ultimate 10 Repair & Protect Shampoo 900mL', 17);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('dove-body-wash.jpg', 'Dove Body Wash', 17, 'Health & Beauty' , 'Dove Body Wash Restoring Coconut & Almond Oils 1L', 3);
insert into products(productImage, productName, productPrice, productCategory, productDescription, productStock) values('dove-body-lotion.jpg', 'Dove Body Lotion', 16, 'Health & Beauty' , 'Dove Body Lotion Almond Oils 1L', 3);

-- Adding record to the orders table
insert into orders(orderDate, customerID) values('2022-01-22', 1);
insert into orders(orderDate, customerID) values('2022-02-23', 2);
insert into orders(orderDate, customerID) values('2022-04-05', 3);
insert into orders(orderDate, customerID) values('2022-04-13', 4);
insert into orders(orderDate, customerID) values('2022-04-17', 5);
insert into orders(orderDate, customerID) values('2022-04-29', 6);
insert into orders(orderDate, customerID) values('2022-05-02', 7);
insert into orders(orderDate, customerID) values('2022-05-19', 8);
insert into orders(orderDate, customerID) values('2022-05-26', 9);
insert into orders(orderDate, customerID) values('2022-06-10', 10);
insert into orders(orderDate, customerID) values('2022-06-14', 11);
insert into orders(orderDate, customerID) values('2022-06-17', 12);
insert into orders(orderDate, customerID) values('2022-06-21', 13);
insert into orders(orderDate, customerID) values('2022-07-15', 14);
insert into orders(orderDate, customerID) values('2022-08-27', 15);
insert into orders(orderDate, customerID) values('2022-09-23', 16);
insert into orders(orderDate, customerID) values('2022-10-11', 17);
insert into orders(orderDate, customerID) values('2022-11-25', 18);
insert into orders(orderDate, customerID) values('2022-12-01', 19);
insert into orders(orderDate, customerID) values('2023-01-15', 20);

-- Adding record to the orderProduct table
insert into orderProducts(orderID, productID, quantity) values(1, 1, 5);
insert into orderProducts(orderID, productID, quantity) values(2, 2, 4);
insert into orderProducts(orderID, productID, quantity) values(3, 3, 3);
insert into orderProducts(orderID, productID, quantity) values(4, 4, 2);
insert into orderProducts(orderID, productID, quantity) values(5, 5, 1);
insert into orderProducts(orderID, productID, quantity) values(6, 11, 6);
insert into orderProducts(orderID, productID, quantity) values(7, 12, 7);
insert into orderProducts(orderID, productID, quantity) values(8, 13, 8);
insert into orderProducts(orderID, productID, quantity) values(9, 14, 9);
insert into orderProducts(orderID, productID, quantity) values(10, 15, 8);
insert into orderProducts(orderID, productID, quantity) values(11, 6, 7);
insert into orderProducts(orderID, productID, quantity) values(12, 7, 6);
insert into orderProducts(orderID, productID, quantity) values(13, 8, 5);
insert into orderProducts(orderID, productID, quantity) values(14, 9, 4);
insert into orderProducts(orderID, productID, quantity) values(15, 10, 5);
insert into orderProducts(orderID, productID, quantity) values(16, 16, 3);
insert into orderProducts(orderID, productID, quantity) values(17, 17, 6);
insert into orderProducts(orderID, productID, quantity) values(18, 18, 2);
insert into orderProducts(orderID, productID, quantity) values(19, 19, 3);
insert into orderProducts(orderID, productID, quantity) values(20, 10, 3);