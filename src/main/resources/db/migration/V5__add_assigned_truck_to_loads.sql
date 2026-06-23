ALTER TABLE loads
ADD COLUMN assigned_truck_id UUID;

ALTER TABLE loads
ADD CONSTRAINT fk_load_truck
FOREIGN KEY (assigned_truck_id)
REFERENCES trucks(id);