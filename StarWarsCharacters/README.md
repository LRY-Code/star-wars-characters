# Star Wars Characters App

An example app that shows information about Star Wars characters

## Things that were omitted due to time constraints
- Using a layer between the network code and the UI code, so that the ViewModel does not directly call the API. The model data class StarWarsApiCharacter.kt of the network should also not directly be used in the UI layer but instead be mapped to another data class that is then used there.
- moving sizes (dp) and String resources into resource files
- handling errors like SocketTimeoutException
- locally storing the results from the API call
- using Dependency Injection like Hilt / Dagger
- automatic testing
- using git branches instead of just committing directly into the master branch
- changing the default app icon and improving the theming and UI design
- accessibility features