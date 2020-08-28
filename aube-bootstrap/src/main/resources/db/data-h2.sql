DELETE FROM user;
INSERT INTO user (name, birthday, user_type) VALUES
('Jone', '1995-07-07', 'NORMAL'),
('Jack', '2000-01-01', 'NORMAL'),
('Tom', '1930-10-10', 'NORMAL'),
('Sandy', '2020-08-11', 'NORMAL'),
('Billie', '2008-08-08', 'ADMIN');


DELETE FROM product;
INSERT INTO product (user_Id, name, amount, order_date) VALUES
(1, '测试商品1', 10000, '2020-08-28'),
(1, '测试商品2', 20000, '2020-08-29'),
(1, '测试商品3', 30000, '2020-08-30'),
(1, '测试商品4', 40000, '2020-08-31'),
(1, '测试商品5', 50000, '2020-09-01');