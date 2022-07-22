INSERT INTO product(id, name) VALUES (1, 'test product 1'), (2, 'test product 2');
INSERT INTO service(id, name) VALUES (1, 'test service 1'), (2, 'test service 2'), (3, 'test service 3');
INSERT INTO product_service(product_id, service_id) VALUES (1, 1), (1, 2), (2, 2), (2, 3)
