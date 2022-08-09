INSERT INTO product(id, name, field1, field2, field3, field4, field5, field6)
VALUES (1, 'test product 1', 'test', 'test', 1, 2.5, 'test', 'test'),
       (2, 'test product 2', 'test', 'test', 1, 2.5, 'test', 'test');
INSERT INTO service(id, name) VALUES (1, 'test service 1'), (2, 'test service 2'), (3, 'test service 3');
INSERT INTO product_service(product_id, service_id) VALUES (1, 1), (1, 2), (2, 2), (2, 3)
