DROP TABLE IF EXISTS
    users;
CREATE TABLE users(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(255) NOT NULL UNIQUE,
                      PASSWORD VARCHAR(255) NOT NULL,
                      role VARCHAR(50) NOT NULL,
                      first_name VARCHAR(255) NOT NULL,
                      last_name VARCHAR(255) NOT NULL
);

INSERT INTO users(
    username,
    password,
    role,
    first_name,
    last_name
)
   VALUES(
             'manager1',
             'BGDKKN VNQKC',
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
          'BGDKKN VNQKC',
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
          'BGDKKN VNQKC',
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
          'BGDKKN VNQKC',
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
          'BGDKKN VNQKC',
          'USER',
          'Mohammed',
          'Faisal Bin Yusof'
      );