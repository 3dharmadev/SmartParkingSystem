# Car Parking System in Java

This Java project implements a versatile car parking system with a modular design. The system supports various functionalities such as initialization, adding/removing vehicles, and checking availability. It includes a flat cost structure for parking fees and is designed to be flexible for future extensions.

## Classes

1. **ParkingLot:** Manages parking spaces.
2. **Vehicle:** Represents vehicles with essential attributes.
3. **Floor:** Represents parking lot floors with capacity details.
4. **VehicleSpace:** Represents individual parking spaces.
5. **CostStrategy:** Manages cost calculation based on vehicle type.

## Usage

1. **Initialization:**
   - Configure the parking lot with desired floors and spaces per floor.

2. **Add Vehicle:**
   - Use the `addVehicle` method to add vehicles with details like type, registration number, and color.

3. **Remove Vehicle:**
   - Remove vehicles by specifying the registration number or token.

4. **Check Availability:**
   - Verify available vehicle spaces on a specific floor for a given vehicle type using `checkAvailability`.

## Cost Structure

- Bike: ₹10 per hour
- Car/Jeep: ₹20 per hour
- Bus/Truck: ₹30 per hour

## Use Case

1. **Initialization for Cars:**
   - Set up the parking lot for two cars.

2. **Vehicle Entry:**
   - Add details for two cars, generating a token ID for each with a timestamp.

3. **Vehicle Exit:**
   - Validate tokens and timestamps to retrieve car details along with the total parking fee.

4. **Capacity Full:**
   - Attempting to enter a third car when the capacity is full should result in an error.

## Project Expectations

- Main method in the Java code project.
- Configuration initialization for capacity, floors, vehicle types, currency, and hourly charges.
- Vehicle entry and exit using either registration number or token.

---

Feel free to modify this `README.md` as needed for your project documentation.
