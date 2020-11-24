package cl.desafiolatam.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageViewRight)
    ImageView imageViewRight;
    @BindView(R.id.imageViewLeft)
    ImageView imageViewLeft;
    @BindView(R.id.imageViewCenter)
    ImageView imageViewCenter;
    @BindView(R.id.imagenPremio)
    ImageView imagenpremio;
    @BindView(R.id.replayButton)
    ImageButton replayButton;
    @BindView(R.id.textViewGift1)
    TextView textViewGift1;
    List<Integer> gifts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.replayButton})
    public void onReplay() {
        imagenpremio.setVisibility(View.INVISIBLE);
        cambiarTexto(4);
    }

    @OnClick({R.id.imageViewRight, R.id.imageViewLeft, R.id.imageViewCenter})
    public void onClick(View view) {
        giftDeliver();
        int gift = getGift();
        imagenpremio.setImageResource(gift);
        imagenpremio.setVisibility(View.VISIBLE);
        cambiarTexto(gift);
    }

    private void cambiarTexto(int gift) {
        switch (gift) {
            case R.drawable.ic_gift_beach:
                textViewGift1.setText("Felicidades: Te ganaste 2 pasajes a la playa");
                break;
            case R.drawable.ic_gift_music:
                textViewGift1.setText("Felicidades: Te ganaste 2 entradas a un recital");
                break;
            case R.drawable.ic_gift_pizza:
                textViewGift1.setText("Felicidades: Te ganaste 2 cenas en pizzeria");
                break;
            case 4:
                textViewGift1.setText("Tenemos un premio para ti");
                break;
        }
    }


    private int getGift() {
        Collections.shuffle(gifts);
        return gifts.get(0);


    }

    private void giftDeliver() {
        gifts.add(R.drawable.ic_gift_beach);
        gifts.add(R.drawable.ic_gift_music);
        gifts.add(R.drawable.ic_gift_pizza);
    }


}


