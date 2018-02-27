# Minecraft Statistics Web API

Runs on Spring Boot

## Endpoints

All endpoints begin with `/api`, if there is an indented list, that lists the parameters for that endpoint.

- GET `/withers/killed` - Get how many withers have been killed
- POST `/withers/killed` - Increment the wither kills
    - `amount` - __(Required)__ Amount to increase the kills with
- POST `/withers/reset` - Reset the kills to `0`