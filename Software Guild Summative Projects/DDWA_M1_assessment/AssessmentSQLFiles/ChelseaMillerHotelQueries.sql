-- 1.Write a query that returns a list of reservations that end in July 2023, including the name of the guest, the room number(s), and the reservation dates.
USE HotelReservationSchema;
SELECT g.FirstName, g.LastName, r.Room_RoomNumber, r.StartDate, r.EndDate
FROM RESERVATIONS r
INNER JOIN Guest g
ON g.idGuest = r.Guest_idGuest
WHERE EndDate < '2023-08-01' AND EndDate > '2023-06-30';

-- 'Chelsea Miller','205','2023-06-28 00:00:00','2023-07-02 00:00:00'
-- 'Walter Holaway','204','2023-07-13 00:00:00','2023-07-14 00:00:00'
-- 'Wilfred Vise','401','2023-07-18 00:00:00','2023-07-21 00:00:00'
-- 'Bettyann Seery','305','2023-07-28 00:00:00','2023-07-29 00:00:00'



-- 2.Write a query that returns a list of all reservations for rooms with a jacuzzi, displaying the guest's name, the room number, and the dates of the reservation.
USE HotelReservationSchema;
SELECT g.FirstName, g.LastName,  r.Room_RoomNumber, r.StartDate, r.EndDate
FROM RESERVATIONS r
INNER JOIN Guest g
ON g.idGuest = r.Guest_idGuest
INNER JOIN Room ro 
ON r.Room_RoomNumber = ro.RoomNumber
INNER JOIN RoomAmenities ra
ON ra.Room_RoomNumber = ro.RoomNumber
INNER JOIN Amenities a
ON a.idAmenity = ra.Amenities_idAmenity
WHERE a.Amenity= 'Jacuzzi';

-- 'Karie Yang','201','2023-03-06 00:00:00','2023-03-07 00:00:00'
-- 'Bettyann Seery','203','2023-02-05 00:00:00','2023-02-10 00:00:00'
-- 'Karie Yang','203','2023-09-13 00:00:00','2023-09-15 00:00:00'
-- 'Chelsea Miller','205','2023-06-28 00:00:00','2023-07-02 00:00:00'
-- 'Walter Holaway','301','2023-04-09 00:00:00','2023-04-13 00:00:00'
-- 'Mack Simmer','301','2023-11-22 00:00:00','2023-11-25 00:00:00'
-- 'Duane Cullison','305','2023-02-23 00:00:00','2023-02-24 00:00:00'
-- 'Bettyann Seery','305','2023-07-28 00:00:00','2023-07-29 00:00:00'
-- 'Bettyann Seery','305','2023-08-30 00:00:00','2023-09-01 00:00:00'
-- 'Chelsea Miller','307','2023-03-17 00:00:00','2023-03-20 00:00:00'


-- 3.Write a query that returns all the rooms reserved for a specific guest, including the guest's name, the room(s) reserved, the starting date of the reservation, and how many people were included in the reservation. (Choose a guest's name from the existing data.)

USE HotelReservationSchema;
SELECT g.FirstName, g.LastName,  r.Room_RoomNumber, r.StartDate, r.Adults + r.Children
FROM RESERVATIONS r
INNER JOIN Guest g
ON g.idGuest = r.Guest_idGuest
WHERE r.Guest_idGuest = 3;

-- 'Bettyann Seery','203','2023-02-05 00:00:00','3'
-- 'Bettyann Seery','303','2023-07-28 00:00:00','3'
-- 'Bettyann Seery','305','2023-08-30 00:00:00','1'


-- 4.Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation. The results should include all rooms, whether or not there is a reservation associated with the room.

USE HotelReservationSchema;
SELECT ro.RoomNumber, r.idReservations, r.TotalRoomCost
FROM Room ro 
LEFT OUTER JOIN RESERVATIONS r
ON r.Room_RoomNumber = ro.RoomNumber
ORDER BY ro.RoomNumber ASC;

-- '201','4','199.99'
-- '202','7','349.98'
-- '203','2','999.95'
-- '203','21','399.98'
-- '204','16','184.99'
-- '205','15','699.96'
-- '206','12','599.96'
-- '206','23','449.97'
-- '207','10','174.99'
-- '208','13','599.96'
-- '208','20','149.99'
-- '301','9','799.96'
-- '301','24','599.97'
-- '302','6','924.95'
-- '302','25','699.96'
-- '303','18','199.99'
-- '304','14','184.99'
-- '305','3','349.98'
-- '305','19','349.98'
-- '306',NULL,NULL
-- '307','5','524.97'
-- '308','1','299.98'
-- '401','11','1199.97'
-- '401','17','1259.97'
-- '401','22','1199.97'
-- '402',NULL,NULL





-- 5.Write a query that returns all the rooms accommodating at least three guests and that are reserved on any date in April 2023.

USE HotelReservationSchema;
SELECT ro.RoomNumber
FROM RESERVATIONS r
INNER JOIN Room ro
ON r.Room_RoomNumber = ro.RoomNumber
INNER JOIN Type t
ON t.size = ro.Type_size
WHERE (r.Adults + r.children) > 2  
AND (('2023-03-31' < StartDate AND StartDate < '2023-05-01') 
OR ('2023-03-31' < EndDate AND EndDate < '2023-05-01')); 

-- '301'
-- '207'



-- 6.Write a query that returns a list of all guest names and the number of reservations per guest, sorted starting with the guest with the most reservations and then by the guest's last name.
USE HotelReservationSchema;
SELECT g.FirstName, g.LastName, count(r.Guest_idGuest) AS theCount
FROM RESERVATIONs r
LEFT OUTER JOIN Guest g
On r.Guest_idGuest =  g.idGuest
GROUP BY r.Guest_idGuest
ORDER BY theCount DESC, g.LastName ASC;

-- 'Mack','Simmer','4'
-- 'Bettyann','Seery','3'
-- 'Duane','Cullison','2'
-- 'Walter','Holaway','2'
-- 'Aurore','Lipton','2'
-- 'Chelsea','Miller','2'
-- 'Maritza','Tilton','2'
-- 'Joleen','Tison','2'
-- 'Wilfred','Vise','2'
-- 'Karie','Yang','2'
-- 'Zachery','Luechtefeld','1'



-- 7.Write a query that displays the name, address, and phone number of a guest based on their phone number. (Choose a phone number from the existing data.)

USE HotelReservationSchema;
SELECT g.FirstName, g.LastName, g.Address, g.Phone
FROM Guest g
WHERE g.Phone = '\(661\) 733-3441';

-- 'Chelsea Miller' '205 van buren st' '(661) 733-3441'


