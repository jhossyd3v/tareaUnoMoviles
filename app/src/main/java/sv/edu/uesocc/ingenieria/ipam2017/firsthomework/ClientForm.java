package sv.edu.uesocc.ingenieria.ipam2017.firsthomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ClientForm extends AppCompatActivity {

    final String[] formaPagoData = new String[]{"Contado","Credito","Anticipado"};

    private Spinner cmbFormaPago;

    private Button btnGuardar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_form);



        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        ArrayAdapter<String> adaptadorPago = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, formaPagoData);
        adaptadorPago.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        cmbFormaPago = (Spinner) findViewById(R.id.spnrFormaPago);

        cmbFormaPago.setAdapter(adaptadorPago);

        if(this.getIntent().hasExtra("clientAction")) {
            Bundle data = this.getIntent().getExtras();

            TextView lblCod = (TextView) findViewById(R.id.LblCod2);
            EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
            EditText txtApellido = (EditText) findViewById(R.id.txtApellidos);
            EditText txtDui = (EditText) findViewById(R.id.txtDui);
            TextView lblTipo = (TextView) findViewById(R.id.LblTipo2);

            lblCod.setText(data.getString("codigo"));
            txtNombre.setText(data.getString("nombre"));
            txtApellido.setText(data.getString("apellido"));
            txtDui.setText(data.getString("dui"));
            lblTipo.setText(data.getString("tipo"));
            if(data.getString("pago").equals("Contado")) {
                cmbFormaPago.setSelection(0);
            } else if(data.getString("pago").equals("Credito")) {
                cmbFormaPago.setSelection(1);
            } else if(data.getString("pago").equals("Anticipado")) {
                cmbFormaPago.setSelection(2);
            }
        }

//        btnVerificar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String pais = cmbPaises.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), "Pais : " + pais, Toast.LENGTH_LONG).show();
//            }
//        });

//        txtCarnetAlumno = (TextView) findViewById(R.id.lblMostrarNombre);
//
//        Bundle datos = this.getIntent().getExtras();
//
//        txtCarnetAlumno.setText("El carnet es: " +  datos.getString("CARNET"));
    }
}
