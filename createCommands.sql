create database studentNetworkingTool;

use studentNetworkingTool;

create table IF NOT EXISTS studentRegistration(
    userName varchar(10),
    password varchar(20),
    primary key(userName)
);

create table IF NOT EXISTS instructorRegistration(
    userName varchar(10),
    password varchar(20),
    primary key(userName)
);

create table IF NOT EXISTS students(
    studentId varchar(16),
    firstName varchar(20),
    lastName varchar(20),
    email varchar(30),
    dateOfBirth date,
    userName varchar(10),
    primary key(studentId),
    foreign key(userName) REFERENCES studentRegistration(userName)
);

create table IF NOT EXISTS courses(
    courseId varchar(16),
    courseName varchar(40),
    isPaidResource boolean,
    primary key(courseId)
);

create table IF NOT EXISTS studentContact(
    contactNo numeric(10),
    studentId varchar(16),
    primary key(contactNo),
    foreign key(studentId) REFERENCES students(studentId)
);

create table IF NOT EXISTS events(
    eventId varchar(16),
    eventName varchar(20),
    primary key(eventId)
);

create table IF NOT EXISTS instructors(
    instructorId varchar(16),
    teachingExperience numeric(2),
    firstName varchar(20),
    lastName varchar(20),
    email varchar(30),
    dateOfBirth date,
    userName varchar(10),
    primary key(instructorId),
    foreign key(userName) REFERENCES instructorRegistration(userName)
);

create table IF NOT EXISTS instructorContact(
    contactNo numeric(10),
    instructorId varchar(16),
    primary key(contactNo),
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table IF NOT EXISTS enrollment(
    studentId varchar(16),
    courseId varchar(16),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table IF NOT EXISTS eventParticipation(
    studentId varchar(16),
    eventId varchar(16),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(eventId) REFERENCES events(eventId)
);

create table IF NOT EXISTS teaches(
    instructorId varchar(16),
    courseId varchar(16),
    foreign key(instructorId) REFERENCES instructors(instructorId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table IF NOT EXISTS corporateProfessionals(
    instructorId varchar(16),
    companyName varchar(20),
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table IF NOT EXISTS professors(
    instructorId varchar(16),    
    universityName varchar(50),
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table IF NOT EXISTS queries(
    queryId varchar(16),
    question varchar(100),
    studentId varchar(16),
    courseId varchar(16),
    primary key(queryId),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table IF NOT EXISTS queryResponses(
    instructorId varchar(16),
    response varchar(100),    
    queryId varchar(16),
    foreign key(queryId) REFERENCES queries(queryId),
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table IF NOT EXISTS queryTags(
    hashtags varchar(10),
    queryId varchar(16),
    primary key(hashtags),
    foreign key(queryId) REFERENCES queries(queryId)
);

create table IF NOT EXISTS payment(
    transactionId varchar(16),
    paymentType varchar(20),
    amount numeric(6),
    isTransactionSuccessful boolean,
    studentId varchar(16),
    courseId varchar(16),
    primary key(transactionId),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table IF NOT EXISTS cardPayment(
    cardHolder varchar(20),
    cardNo numeric(16),
    expiryMonth numeric(2),
    expiryYear numeric(2),
    cvv numeric(4),
    transactionId varchar(16),
    foreign key(transactionId) REFERENCES payment(transactionId)
);

create table IF NOT EXISTS electronicCheck(
    accountHolder varchar(20),
    routingNo numeric(16),
    bankName varchar(20),
    branch varchar(20),
    transactionId varchar(16),
    foreign key(transactionId) REFERENCES payment(transactionId)
);