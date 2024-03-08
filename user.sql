DROP TABLE IF EXISTS
    users;
CREATE TABLE users(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(255) NOT NULL UNIQUE,
                      PASSWORD VARCHAR(255) NOT NULL,
                      role VARCHAR(50) NOT NULL,
                      first_name VARCHAR(255) NOT NULL,
                      last_name VARCHAR(255) NOT NULL
); INSERT INTO users(
    username,
    password,
    role,
    first_name,
    last_name
)
   VALUES(
             'manager1',
             'password123',
             'MANAGER',
             'Tan',
             'Wei Ming'
         );
INSERT INTO users(
    username,
    password,
    role,
    first_name,
    last_name
)
VALUES(
          'manager2',
          'password123',
          'MANAGER',
          'Siti',
          'Binti Zahara'
      );
INSERT INTO users(
    username,
    password,
    role,
    first_name,
    last_name
)
VALUES(
          'user1',
          'password123',
          'USER',
          'Raj',
          'Sharma'
      );
INSERT INTO users(
    username,
    password,
    role,
    first_name,
    last_name
)
VALUES(
          'user2',
          'password123',
          'USER',
          'Lim',
          'Xiu Ling'
      );
INSERT INTO users(
    username,
    password,
    role,
    first_name,
    last_name
)
VALUES(
          'user3',
          'password123',
          'USER',
          'Mohammed',
          'Faisal Bin Yusof'
      );