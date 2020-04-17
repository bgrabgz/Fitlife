package com.example.deneme1;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ListView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.List;


public class not extends AppCompatActivity {

    DatabaseReference reference;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        listView = findViewById(R.id.listView);

        reference = FirebaseDatabase.getInstance().getReference().child("Kullanıcılar").child(mUser.getUid());

        Log.d(not.class.getName(), "onCreate: ");

        final ArrayList<String> arrayList = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                    if( postSnapShot.child("string").getValue() != null) {
                        String not = postSnapShot.child("string").getValue().toString();
                        Log.d(not.class.getName(), "onDataChange: " + not);
                        arrayList.add(not);
                    } else {
                        Log.d(not.class.getName(), "onCreate: " +arrayList.get(0));
                        init(arrayList);}
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void init(ArrayList<String> string){
        listView.setAdapter(new ListAdapter(this,getApplicationContext(),string));
    }
}