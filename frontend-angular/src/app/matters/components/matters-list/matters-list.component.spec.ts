import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MattersListComponent } from './matters-list.component';

describe('MattersListComponent', () => {
  let component: MattersListComponent;
  let fixture: ComponentFixture<MattersListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MattersListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MattersListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
