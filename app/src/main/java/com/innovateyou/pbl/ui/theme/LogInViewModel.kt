package com.innovateyou.pbl.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.innovateyou.pbl.data.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LogInViewModel @Inject constructor( val auth : FirebaseAuth) : ViewModel(){
    var Finding = mutableStateOf(true)
    var Budget = mutableStateOf("Select")
    var Electricity = mutableStateOf("Select")
    var Mate = mutableStateOf("Select")
    var Query = mutableStateOf("")
    var add_roomName = mutableStateOf("")
    var add_Rent = mutableStateOf("")
    var add_ownerName = mutableStateOf("")
    var add_address = mutableStateOf("")
    var add_description = mutableStateOf("")
    var add_beds = mutableStateOf("")
    var add_electricity = mutableStateOf("")
    var selectedMode =  mutableStateOf("student")
    var EntryNo = mutableStateOf(0)
    val filteredRoomList = if (Query.value.isBlank()) {
        roomList
    } else {
        roomList.filter { room ->
            room.ApartName.contains(Query.value, ignoreCase = true)
        }
    }

    val SignedIn = mutableStateOf(false)
    val InProgress = mutableStateOf(false)

    fun onSignUp(email:String , pass:String){
        InProgress.value = true
        auth.createUserWithEmailAndPassword(email , pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    SignedIn.value = true
                }
                else{

                }
            }
        InProgress.value = false
    }
    fun Login(email: String , pass: String){
        InProgress.value = true
        auth.signInWithEmailAndPassword(email , pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    SignedIn.value = true
                }
                else{

                }
            }
        InProgress.value = false
    }
    fun signOut() {
        auth.signOut()
        SignedIn.value = false
    }

    private val database = FirebaseDatabase.getInstance().reference

    fun addApartment(apartment: Room) {
        val apartmentId = database.child("apartments").push().key
        if (apartmentId != null) {
            database.child("apartments").child(apartmentId).setValue(apartment)
        }
    }
    fun getAllApartments(): LiveData<List<Room>> {
        val apartmentsLiveData = MutableLiveData<List<Room>>()
        database.child("apartments").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val apartments = mutableListOf<Room>()
                for (apartmentSnapshot in snapshot.children) {
                    val apartment = apartmentSnapshot.getValue(Room::class.java)
                    if (apartment != null) {
                        apartments.add(apartment)
                    }
                }
                apartmentsLiveData.postValue(apartments)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
        return apartmentsLiveData
    }

}
