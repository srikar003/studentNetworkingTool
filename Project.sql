create database studentNetworkingTool;

use studentNetworkingTool;

create table studentRegistration(
    userName varchar(10) not null,
    password varchar(20)not null,
    primary key(userName)
);

create table instructorRegistration(
    userName varchar(10) not null,
    password varchar(20) not null,
    primary key(userName)
);

create table students(
    studentId varchar(16) not null,
    firstName varchar(20) not null,
    lastName varchar(20),
    email varchar(30) not null,
    dateOfBirth date not null,
    userName varchar(10) not null,
    collegeName varchar(20) not null,
    department varchar(15) not null,
    primary key(studentId),
    foreign key(userName) REFERENCES studentRegistration(userName)
);

create table courses(
    courseId varchar(16) not null,
    courseName varchar(40) not null,
    isPaidResource boolean not null,
    primary key(courseId)
);

create table studentContact(
    contactNo numeric(10),
    studentId varchar(16),
    primary key(contactNo),
    foreign key(studentId) REFERENCES students(studentId)
);

create table events(
    eventId varchar(16),
    eventName varchar(20),
    primary key(eventId)
);

create table instructors(
    instructorId varchar(16) not null,
    teachingExperience numeric(2),
    firstName varchar(20) not null,
    lastName varchar(20),
    email varchar(30) not null,
    dateOfBirth date,
    userName varchar(10) not null,
    primary key(instructorId),
    foreign key(userName) REFERENCES instructorRegistration(userName)
);

create table instructorContact(
    contactNo numeric(10),
    instructorId varchar(16),
    primary key(contactNo),
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table enrollment(
    studentId varchar(16),
    courseId varchar(16),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table eventParticipation(
    studentId varchar(16),
    eventId varchar(16),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(eventId) REFERENCES events(eventId)
);

create table teaches(
    instructorId varchar(16) not null,
    courseId varchar(16) not null,
    foreign key(instructorId) REFERENCES instructors(instructorId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table corporateProfessionals(
    instructorId varchar(16) not null,
    companyName varchar(20) not null,
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table professors(
    instructorId varchar(16) not null,    
    universityName varchar(50) not null,
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table queries(
    queryId varchar(16),
    question varchar(100),
    studentId varchar(16),
    courseId varchar(16),
    primary key(queryId),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table queryResponses(
    instructorId varchar(16),
    response varchar(100),    
    queryId varchar(16),
    foreign key(queryId) REFERENCES queries(queryId),
    foreign key(instructorId) REFERENCES instructors(instructorId)
);

create table queryTags(
    hashtags varchar(10),
    queryId varchar(16),
    primary key(hashtags),
    foreign key(queryId) REFERENCES queries(queryId)
);

create table payment(
    transactionId numeric(30) not null,
    paymentType varchar(20) not null,
    amount numeric(6),
    isTransactionSuccessful boolean not null,
    studentId varchar(16) not null,
    courseId varchar(16),
    primary key(transactionId),
    foreign key(studentId) REFERENCES students(studentId),
    foreign key(courseId) REFERENCES courses(courseId)
);

create table cardPayment(
    cardHolder varchar(20),
    cardNo numeric(16),
    expiryMonth numeric(2),
    expiryYear numeric(2),
    cvv numeric(4),
    transactionId numeric(30),
    foreign key(transactionId) REFERENCES payment(transactionId)
);

create table electronicCheck(
    accountHolder varchar(20),
    routingNo numeric(16),
    bankName varchar(20),
    branch varchar(20),
    transactionId numeric(30),
    foreign key(transactionId) REFERENCES payment(transactionId)
);