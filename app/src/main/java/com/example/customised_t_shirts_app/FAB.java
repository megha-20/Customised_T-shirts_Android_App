package com.example.customised_t_shirts_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FAB extends AppCompatActivity {

    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

        products=new ArrayList<>();
        products.add(new Product("Men's V-neck Half sleeve T-shirt","T-shirts","Available Sizes: S M L XL\nAvailable Colors: pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr1));
        products.add(new Product("Men's V-neck Half sleeve T-shirt","T-shirts","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr2));
        products.add(new Product("Women's V-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr3));
        products.add(new Product("Men's Round-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr4));
        products.add(new Product("Men's Round-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr5));
        products.add(new Product("Men's Round-neck full sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr6));
        products.add(new Product("Men's V-neck full sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr7));
        products.add(new Product("Men's Round-neck full sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr8));
        products.add(new Product("Men's V-neck full sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr9));
        products.add(new Product("Women's Round-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr10));
        products.add(new Product("Men's Round-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr11));
        products.add(new Product("Men's collar-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr12));
        products.add(new Product("Women's collar-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr13));
        products.add(new Product("Men's collar-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr14));
        products.add(new Product("Women's collar-neck Half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr15));
        products.add(new Product("Women's collar-neck full sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr16));
        products.add(new Product("Men's Round-neck sleeveless T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr17));
        products.add(new Product("Men's Round-neck full sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr25));
        products.add(new Product("Men's Round-neck half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr26));
        products.add(new Product("Women's Round-neck half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr27));
        products.add(new Product("Men's Round-neck half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr28));
        products.add(new Product("Men's Round-neck half sleeve T-shirt","shirt","Available Sizes: S M L XL\nAvailable Colors pink,green\nCotton Jersey\nFeatures:\n100% combed\nGSM:160,180,200\nSingle Jersey Fabric\nAssurance for Shrinkage and\nColor\nBio washed fabric\nDouble Stitched\nBiowashed Fabric\n",R.drawable.pr29));

        RecyclerView myproduct=(RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,products);
        myproduct.setLayoutManager(new GridLayoutManager(this,3));
        myproduct.setAdapter(myAdapter);

    }
}
