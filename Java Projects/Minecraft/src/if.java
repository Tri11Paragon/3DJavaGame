/*    */ 
/*    */ 
/*    */ public class if
/*    */   extends aw
/*    */ {
/*  6 */   protected float[] g = new float['Ā'];
/*  7 */   protected float[] h = new float['Ā'];
/*  8 */   protected float[] i = new float['Ā'];
/*  9 */   protected float[] j = new float['Ā'];
/* 10 */   int k = 0;
/*    */   
/*    */   public if() {
/* 13 */     super(uu.D.bm + 1);
/* 14 */     this.e = 2;
/*    */   }
/*    */   
/*    */   public void a() {
/* 18 */     this.k += 1;
/* 19 */     float f1; int i2; int i3; int i4; int i5; int i6; for (int m = 0; m < 16; m++) {
/* 20 */       for (n = 0; n < 16; n++) {
/* 21 */         f1 = 0.0F;
/* 22 */         int i1 = (int)(in.a(n * 3.1415927F * 2.0F / 16.0F) * 1.2F);
/* 23 */         i2 = (int)(in.a(m * 3.1415927F * 2.0F / 16.0F) * 1.2F);
/* 24 */         for (i3 = m - 1; i3 <= m + 1; i3++)
/* 25 */           for (i4 = n - 1; i4 <= n + 1; i4++) {
/* 26 */             i5 = i3 + i1 & 0xF;
/* 27 */             i6 = i4 + i2 & 0xF;
/* 28 */             f1 += this.g[(i5 + i6 * 16)];
/*    */           }
/* 30 */         this.h[(m + n * 16)] = (f1 / 10.0F + (this.i[((m + 0 & 0xF) + (n + 0 & 0xF) * 16)] + this.i[((m + 1 & 0xF) + (n + 0 & 0xF) * 16)] + this.i[((m + 1 & 0xF) + (n + 1 & 0xF) * 16)] + this.i[((m + 0 & 0xF) + (n + 1 & 0xF) * 16)]) / 4.0F * 0.8F);
/*    */         
/* 32 */         this.i[(m + n * 16)] += this.j[(m + n * 16)] * 0.01F;
/*    */         
/* 34 */         if (this.i[(m + n * 16)] < 0.0F) this.i[(m + n * 16)] = 0.0F;
/* 35 */         this.j[(m + n * 16)] -= 0.06F;
/* 36 */         if (Math.random() < 0.005D)
/* 37 */           this.j[(m + n * 16)] = 1.5F;
/*    */       }
/*    */     }
/* 40 */     float[] arrayOfFloat = this.h;
/* 41 */     this.h = this.g;
/* 42 */     this.g = arrayOfFloat;
/*    */     
/* 44 */     for (int n = 0; n < 256; n++) {
/* 45 */       f1 = this.g[(n - this.k / 3 * 16 & 0xFF)] * 2.0F;
/* 46 */       if (f1 > 1.0F) f1 = 1.0F;
/* 47 */       if (f1 < 0.0F) { f1 = 0.0F;
/*    */       }
/* 49 */       float f2 = f1;
/* 50 */       i2 = (int)(f2 * 100.0F + 155.0F);
/* 51 */       i3 = (int)(f2 * f2 * 255.0F);
/* 52 */       i4 = (int)(f2 * f2 * f2 * f2 * 128.0F);
/*    */       
/* 54 */       if (this.c) {
/* 55 */         i5 = (i2 * 30 + i3 * 59 + i4 * 11) / 100;
/* 56 */         i6 = (i2 * 30 + i3 * 70) / 100;
/* 57 */         int i7 = (i2 * 30 + i4 * 70) / 100;
/*    */         
/* 59 */         i2 = i5;
/* 60 */         i3 = i6;
/* 61 */         i4 = i7;
/*    */       }
/*    */       
/* 64 */       this.a[(n * 4 + 0)] = ((byte)i2);
/* 65 */       this.a[(n * 4 + 1)] = ((byte)i3);
/* 66 */       this.a[(n * 4 + 2)] = ((byte)i4);
/* 67 */       this.a[(n * 4 + 3)] = -1;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Brett\AppData\Roaming\.minecraft\versions\b1.7.3_HACKS\b1.7.3_HACKS.jar!\if.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */