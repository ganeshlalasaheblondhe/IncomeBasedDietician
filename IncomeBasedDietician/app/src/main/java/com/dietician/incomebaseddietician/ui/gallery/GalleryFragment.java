package com.dietician.incomebaseddietician.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dietician.incomebaseddietician.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    Spinner spin;
    String[] gender = { "Male", "Female" };
    String spin_val;
    EditText weight,he;
      TextView tvBMI;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
            weight = root.findViewById(R.id.editText1weight);
         he = root.findViewById(R.id.editText2Height);
        final Button bmi = root.findViewById(R.id.buttonbmi);
        tvBMI = root.findViewById(R.id.tvbmi);
        spin = root.findViewById(R.id.spinner);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
             int  position, long id) {

               spin_val = gender[position];//saving the value selected

            }

            @Override

            public void onNothingSelected(AdapterView<?> arg0) {
}

        });

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item, gender);

// setting adapters to spinners

        spin.setAdapter(spin_adapter);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weightt = Integer.parseInt(weight.getText().toString());
                int height = Integer.parseInt(he.getText().toString());
                if(spin_val.toUpperCase().contains("FE"))
                {

                    double bmiint = (703 * (double)(weightt*1.0 / (1.0*height * height*1.0)));

                    String bstring = "";
                    if(bmiint<18)
                        bstring = "Your BMI is: \""+ bmiint + "\" That Means You Are UnderWeight";
                    else if(bmiint>=18 && bmiint < 25)
                        bstring = "Your BMI is: \""+ bmiint + "\" That Means You Are Healthy";
                    else if(bmiint>= 25 && bmiint < 29)
                        bstring = "Your BMI is: \""+ bmiint + "\" That Means You Are Over Weight";
                    else if(bmiint>= 29)
                        bstring = "Your BMI is: \""+ bmiint + "\" That Means You Are Obese";

                    tvBMI.setText(bstring);

                }
                else
                {
                    double bmiint = (703 * (double)(weightt*1.0 / (1.0*height * height*1.0)));

                    String bstring = "";
                    if(bmiint<18)
                        bstring = "Your BMI is: "+ bmiint + " That Means You Are UnderWeight";
                    else if(bmiint>=18 && bmiint < 25)
                        bstring = "Your BMI is: "+ bmiint + " That Means You Are Healthy";
                    else if(bmiint>= 25 && bmiint < 29)
                        bstring = "Your BMI is: "+ bmiint + " That Means You Are Over Weight";
                    else if(bmiint>= 29)
                        bstring = "Your BMI is: "+ bmiint + " That Means You Are Obese";

                    tvBMI.setText(bstring);
                }
            }
        });

        return root;
    }
}