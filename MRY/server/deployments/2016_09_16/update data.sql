-- �ƶ�����������¼��Ĺ�ϵ
UPDATE service_package_buy_record s JOIN consume_record r ON s.id = r.service_package_record_id SET s.customer_id = r.customer_id, s.consume_record_id = r.id;
	
-- �����û���ǰ�ķ����
UPDATE customer SET service_package_id = 1, service_package_start_time = register_time;
UPDATE customer c JOIN service_package_buy_record spbr ON c.id = spbr.customer_id SET c.service_package_id = spbr.service_package_id, c.service_package_start_time = spbr.start_time WHERE spbr.start_time < NOW() && spbr.end_time > NOW();

-- ɾ���û���is_free�ֶ�
ALTER TABLE customer DROP COLUMN is_free;

-- ɾ�����Ѽ�¼��ͷ���������¼���������
ALTER TABLE consume_record DROP FOREIGN KEY FK_mdqvj3snungyw2bwjqowu6fnr;
ALTER TABLE consume_record DROP COLUMN service_package_record_id;