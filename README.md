Timezone and UTC Date to Local date Formatter
=========

Develop a small application to read a CSV with a UTC datetime, latitude and longitude columns and append the timezone
the vehicle is in and the localised datetime. See example of CSV input and output below.

Input
2013-07-10 02:52:49,-44.490947,171.220966
2013-07-10 02:52:49,-33.912167,151.215820

Output
2013-07-10 02:52:49,-44.490947,171.220966,Pacific/Auckland,2013-07-10T14:52:49
2013-07-10 02:52:49,-33.912167,151.215820,Australia/Sydney,2013-07-10T12:52:49
