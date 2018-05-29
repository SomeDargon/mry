-- �޸���ҩ������ֶ�����
ALTER TABLE medication_using_situation MODIFY using_frequency VARCHAR(255);

-- ���豸��ʼΪ��Ч

UPDATE customer_device SET isactive=true;

-- ҩƷ��λ
INSERT INTO data_dictionary (text,type,is_active) VALUES ('g','MedicineUnit',1);
INSERT INTO data_dictionary (text,type,is_active) VALUES ('mg','MedicineUnit',1);
INSERT INTO data_dictionary (text,type,is_active) VALUES ('ug','MedicineUnit',1);
INSERT INTO data_dictionary (text,type,is_active) VALUES ('ml','MedicineUnit',1);
INSERT INTO data_dictionary (text,type,is_active) VALUES ('u','MedicineUnit',1);
INSERT INTO data_dictionary (text,type,is_active) VALUES ('iu','MedicineUnit',1);

-- ��ҩ���
UPDATE medication_using_situation SET using_frequency=CONCAT(using_frequency,'��'),frequency_unit=CONCAT('ÿ',frequency_unit);

-- ��������ʱ������
UPDATE manage_customer_health_list m SET m.upload_time=(
SELECT GREATEST(alarm,assessment,diagnosis,diet,life,telephone) ut FROM (
SELECT id,CASE WHEN alarm IS NULL THEN DATE('1111-11-11 00:00:00') ELSE alarm END AS alarm
              , CASE  WHEN assessment IS NULL THEN DATE('1111-11-11 00:00:00') ELSE assessment END AS assessment,
              CASE  WHEN diagnosis IS NULL THEN DATE('1111-11-11 00:00:00') ELSE diagnosis END AS diagnosis,
              CASE  WHEN diet IS NULL THEN DATE('1111-11-11 00:00:00') ELSE diet END AS diet,
               CASE  WHEN life IS NULL THEN DATE('1111-11-11 00:00:00') ELSE life END AS life,
                CASE  WHEN telephone IS NULL THEN DATE('1111-11-11 00:00:00') ELSE telephone END AS telephone
               FROM manage_customer_health_list) AS t1 WHERE id=m.id
) WHERE 1;

UPDATE manage_customer_health_list m SET m.upload_time=NULL WHERE m.upload_time='1111-11-11 00:00:00';