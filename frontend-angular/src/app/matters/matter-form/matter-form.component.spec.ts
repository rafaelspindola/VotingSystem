import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatterFormComponent } from './matter-form.component';

describe('MatterFormComponent', () => {
  let component: MatterFormComponent;
  let fixture: ComponentFixture<MatterFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatterFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MatterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
