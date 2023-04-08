@ALl
Feature : Hybird Mobile application
 I Want to test downloading and sorting functions and performance of the app
@AnonymousUserDownloads
Scenario: Anonymous user cannot download more than three books
Given  Latest ten books are displayed in home page
And User not registered before
When User download first book
And User download second book
And User download third book
Then User not able to download third book



@LowBatteryPerformance
Scenario: performance of application while the battery die
Given Latest ten books are dsplayed in home page
And Mobile Battery  is low
When User browser the app
Then App should behave in a good manner

@SortingFunction
Scenario : Sorting latest ten books
Given Latest ten books are displayed in home page
When User sort books by choosing logic
Then Books should displayed rearranged successfully
