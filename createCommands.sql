create database IF NOT EXISTS studentNetworkingTool;

use studentNetworkingTool;

create table IF NOT EXISTS studentRegistration(
    userName varchar(10) not null,
    password varchar(20) not null,
    primary key(userName)
);

create table IF NOT EXISTS instructorRegistration(
    userName varchar(10) not null,
    password varchar(20) not null,
    primary key(userName)
);

create table IF NOT EXISTS students(
    studentId varchar(36) not null,
    firstName varchar(20) not null,
    lastName varchar(20),
    email varchar(30) not null,
    dateOfBirth date not null,
    college varchar(20) not null,
    department varchar(15) not null,
    userName varchar(10) not null,
    primary key(studentId),
    foreign key(userName) REFERENCES studentRegistration(userName) on delete cascade on update cascade
);

create table IF NOT EXISTS courses(
    courseId varchar(36) not null,
    courseName varchar(40) not null,
    isPaidCourse boolean not null,
    price numeric(5),
    primary key(courseId)
);

create table IF NOT EXISTS studentContact(
    contactNo numeric(10),
    studentId varchar(36),
    primary key(contactNo),
    foreign key(studentId) REFERENCES students(studentId) on delete cascade on update cascade
);

create table IF NOT EXISTS instructors(
    instructorId varchar(36) not null,
    teachingExperience numeric(2),
    firstName varchar(20) not null,
    lastName varchar(20),
    email varchar(30) not null,
    dateOfBirth date,
    userName varchar(10) not null,
    primary key(instructorId),
    foreign key(userName) REFERENCES instructorRegistration(userName) on delete cascade on update cascade
);

create table IF NOT EXISTS instructorContact(
    contactNo numeric(10),
    instructorId varchar(36),
    primary key(contactNo),
    foreign key(instructorId) REFERENCES instructors(instructorId) on delete cascade on update cascade
);


create table IF NOT EXISTS events(
    eventId varchar(36),
    eventName varchar(20),
    instructorId varchar(36),
    primary key(eventId),    
    foreign key(instructorId) REFERENCES instructors(instructorId) on delete cascade on update cascade
);

create table IF NOT EXISTS enrollment(
    studentId varchar(36),
    courseId varchar(36),
    foreign key(studentId) REFERENCES students(studentId) on delete cascade on update cascade,
    foreign key(courseId) REFERENCES courses(courseId) on delete cascade on update cascade
);

create table IF NOT EXISTS eventParticipation(
    studentId varchar(36),
    eventId varchar(36),
    foreign key(studentId) REFERENCES students(studentId) on delete cascade on update cascade,
    foreign key(eventId) REFERENCES events(eventId) on delete cascade on update cascade
);

create table IF NOT EXISTS teaches(
    instructorId varchar(36) not null,
    courseId varchar(36) not null,
    foreign key(instructorId) REFERENCES instructors(instructorId) on delete cascade on update cascade,
    foreign key(courseId) REFERENCES courses(courseId) on delete cascade on update cascade
);

create table IF NOT EXISTS corporateProfessionals(
    instructorId varchar(36) not null,
    companyName varchar(20) not null,
    foreign key(instructorId) REFERENCES instructors(instructorId) on delete cascade on update cascade
);

create table IF NOT EXISTS professors(
    instructorId varchar(36) not null,
    universityName varchar(50) not null,
    foreign key(instructorId) REFERENCES instructors(instructorId) on delete cascade on update cascade
);

create table IF NOT EXISTS queries(
    queryId varchar(36),
    question varchar(100) not null,
    studentId varchar(36),
    courseId varchar(36),
    primary key(queryId),
    foreign key(studentId) REFERENCES students(studentId) on delete cascade on update cascade,
    foreign key(courseId) REFERENCES courses(courseId) on delete cascade on update cascade
);

create table IF NOT EXISTS queryResponses(
    instructorId varchar(36),
    response varchar(100) not null,
    queryId varchar(36),
    foreign key(queryId) REFERENCES queries(queryId) on delete cascade on update cascade,
    foreign key(instructorId) REFERENCES instructors(instructorId) on delete cascade on update cascade
);

create table IF NOT EXISTS queryTags(
    hashtags varchar(10),
    queryId varchar(36),
    primary key(hashtags),
    foreign key(queryId) REFERENCES queries(queryId) on delete cascade on update cascade
);

create table IF NOT EXISTS payment(
    transactionId varchar(36),
    paymentType varchar(20) not null,
    amount numeric(6),
    isTransactionSuccessful boolean not null,
    studentId varchar(36),
    courseId varchar(36),
    primary key(transactionId),
    foreign key(studentId) REFERENCES students(studentId) on delete cascade on update cascade,
    foreign key(courseId) REFERENCES courses(courseId) on delete cascade on update cascade
);

create table IF NOT EXISTS cardPayment(
    cardHolder varchar(20),
    cardNo numeric(36),
    expiryMonth numeric(2),
    expiryYear numeric(2),
    cvv numeric(4),
    transactionId varchar(36),
    foreign key(transactionId) REFERENCES payment(transactionId) on delete cascade on update cascade
);

create table IF NOT EXISTS electronicCheck(
    accountHolder varchar(20),
    routingNo numeric(36),
    bankName varchar(20),
    branch varchar(20),
    transactionId varchar(36),
    foreign key(transactionId) REFERENCES payment(transactionId) on delete cascade on update cascade
);