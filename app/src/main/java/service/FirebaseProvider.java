package service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import io.reactivex.subjects.BehaviorSubject;

public class FirebaseProvider {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("equipment/1");
    private BehaviorSubject<Weapon> item = BehaviorSubject.create();
    private BehaviorSubject<ArrayList<Weapon>> equipment = BehaviorSubject.create();

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public BehaviorSubject<Weapon> getItem(int id) {
        databaseReference = FirebaseDatabase.getInstance().getReference("equipment/" + id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("asdf", "Got here!");
                item.onNext(dataSnapshot.getValue(Weapon.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("asdf", "YA FUCKED UP BUD!");
            }
        });

        return item;
    }

    public BehaviorSubject<ArrayList<Weapon>> getEquipment() {
        final GenericTypeIndicator<ArrayList<Weapon>> typeIndicator = new GenericTypeIndicator<ArrayList<Weapon>>() {};
        databaseReference = FirebaseDatabase.getInstance().getReference("equipment");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("asdf", "Got here!");
                equipment.onNext(dataSnapshot.getValue(typeIndicator));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("asdf", "YA FUCKED UP BUD!");
            }
        });

        return equipment;
    }
}
